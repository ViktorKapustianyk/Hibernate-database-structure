package org.example.service;

import org.example.dao.*;
import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ServiceManagerTest {

    private static SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private static EntityActorDAO entityActorDAO;
    private static  EntityAddressDAO entityAddressDAO;
    private static EntityCategoryDAO entityCategoryDAO;
    private static EntityCityDAO entityCityDAO;
    private static EntityCountryDAO entityCountryDAO;
    private static EntityCustomerDAO entityCustomerDAO;
    private static EntityFilmDAO entityFilmDAO;
    private static EntityFilmTextDAO entityFilmTextDAO;
    private static EntityInventoryDAO entityInventoryDAO;
    private static EntityLanguageDAO entityLanguageDAO;
    private static EntityPaymentDAO entityPaymentDAO;
    private static EntityRentalDAO entityRentalDAO;
    private static EntityStaffDAO entityStaffDAO;
    private static EntityStoreDAO entityStoreDAO;

    @BeforeAll
    static void setup(){
            sessionFactory = new Configuration()
                    .configure("hibernate_h2.cfg.xml")
                    .buildSessionFactory();

            entityActorDAO = new EntityActorDAO(sessionFactory);
            entityAddressDAO = new EntityAddressDAO(sessionFactory);
            entityCategoryDAO = new EntityCategoryDAO(sessionFactory);
            entityCityDAO = new EntityCityDAO(sessionFactory);
            entityCountryDAO = new EntityCountryDAO(sessionFactory);
            entityCustomerDAO = new EntityCustomerDAO(sessionFactory);
            entityFilmDAO = new EntityFilmDAO(sessionFactory);
            entityFilmTextDAO = new EntityFilmTextDAO(sessionFactory);
            entityInventoryDAO = new EntityInventoryDAO(sessionFactory);
            entityLanguageDAO = new EntityLanguageDAO(sessionFactory);
            entityPaymentDAO = new EntityPaymentDAO(sessionFactory);
            entityRentalDAO = new EntityRentalDAO(sessionFactory);
            entityStaffDAO = new EntityStaffDAO(sessionFactory);
            entityStoreDAO = new EntityStoreDAO(sessionFactory);
    }

    @BeforeEach
    void setupThis(){
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @AfterEach
    void tearThis(){
        session.getTransaction().commit();
    }

    @AfterAll
    static void tear(){
        sessionFactory.close();
    }

    @Test
    void shouldCreateCustomerWithDependenciesAndCheckFields() {
        try {
            assertDoesNotThrow(() -> {
                try (Session session = sessionFactory.getCurrentSession()) {
                    Transaction transaction = session.beginTransaction();

                    EntityStore store = entityStoreDAO.getFirstStore();
                    EntityCity city = entityCityDAO.getFirstCity();

                    EntityAddress address = new EntityAddress();
                    address.setAddress("Indept str, 48");
                    address.setPhone("999-111-555");
                    address.setCity(city);
                    address.setDistrict("West");

                    entityAddressDAO.create(address);

                    EntityCustomer customer = new EntityCustomer();
                    customer.setIsActive(true);
                    customer.setAddress(address);
                    customer.setStore(store);
                    customer.setEmail("test@gmail.com");
                    customer.setFirstName("Vitya");
                    customer.setLastName("Kap");

                    entityCustomerDAO.create(customer);

                    transaction.commit();

                    assertNotNull(customer);
                    assertNotNull(customer.getAddress());
                    assertNotNull(customer.getStore());
                    assertTrue(customer.getIsActive());
                    assertNotNull(customer.getEmail());
                    assertNotNull(customer.getFirstName());
                    assertNotNull(customer.getLastName());
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Test
    void shouldReturnInventoryToStoreAndUpdateReturnDate() {
        try {
            assertDoesNotThrow(() -> {
                try (Session session = sessionFactory.getCurrentSession()) {
                    Transaction transaction = session.beginTransaction();

                    EntityRental rental = entityRentalDAO.getAnyUnrenturnedRantal();
                    rental.setReturnDate(LocalDateTime.now());

                    entityRentalDAO.create(rental);

                    transaction.commit();

                    assertNotNull(rental.getReturnDate());
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Test
    void shouldRentInventoryAndCheckFieldsInInventoryRentalPayment() {
        BigDecimal expectedAmount = BigDecimal.valueOf(55.77);

        try {
            assertDoesNotThrow(() -> {
                try (Session session = sessionFactory.getCurrentSession()) {
                    Transaction transaction = session.beginTransaction();

                    EntityFilm film = entityFilmDAO.getFirstAvailableFilmForRent();

                    EntityStore store = entityStoreDAO.getItems(0, 1).get(0);
                    EntityCustomer customer = entityCustomerDAO.getAnyCustomer();

                    EntityInventory inventory = new EntityInventory();
                    inventory.setFilm(film);
                    inventory.setStore(store);
                    entityInventoryDAO.create(inventory);

                    EntityStaff staff = store.getStaff();

                    EntityRental rental = new EntityRental();
                    rental.setRentalDate(LocalDateTime.now());
                    rental.setCustomer(customer);
                    rental.setInventory(inventory);
                    rental.setStaff(staff);
                    entityRentalDAO.create(rental);

                    EntityPayment payment = new EntityPayment();
                    payment.setCustomer(customer);
                    payment.setStaff(staff);
                    payment.setPaymentDate(LocalDateTime.now());
                    payment.setRental(rental);
                    payment.setAmount(BigDecimal.valueOf(55.77));
                    entityPaymentDAO.update(payment);

                    transaction.commit();

                    assertNotNull(inventory.getFilm());
                    assertNotNull(inventory.getStore());
                    assertNotNull(rental.getRentalDate());
                    assertNotNull(rental.getCustomer());
                    assertNotNull(rental.getInventory());
                    assertNotNull(rental.getStaff());
                    assertNotNull(payment.getCustomer());
                    assertNotNull(payment.getStaff());
                    assertNotNull(payment.getPaymentDate());
                    assertNotNull(payment.getRental());
                    assertEquals(expectedAmount, payment.getAmount());
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Test
    void shouldCreateNewFilmAndCheckAllFieldsInFilmAndFilmText() {
        FilmRating expectedRating = FilmRating.NC_17;
        FilmFeature expectedFeature = FilmFeature.TRAILERS;
        Short expectedLength = 123;
        String expectedDescription = "new fantasy";
        String expectedTitle = "new my-movie";
        Byte expectedRentalDuration = 44;
        Year expectedYear = Year.now();


        try {
            assertDoesNotThrow(() -> {
                try (Session session = sessionFactory.getCurrentSession()) {
                    Transaction transaction = session.beginTransaction();

                    EntityLanguage language = entityLanguageDAO.getAnyLanguage();
                    Set<EntityCategory> categories = entityCategoryDAO.getFirstFourCategories();
                    Set<EntityActor> actors = entityActorDAO.getFirstFourActors();

                    EntityFilm film = new EntityFilm();
                    film.setActors(actors);
                    film.setRating(FilmRating.NC_17);
                    film.setSpecialFeatures(Set.of(FilmFeature.TRAILERS));
                    film.setLength((short)123);
                    film.setReplacementCost(BigDecimal.TEN);
                    film.setRentalRate(BigDecimal.ONE);
                    film.setLanguage(language);
                    film.setOriginalLanguage(language);
                    film.setDescription("new fantasy");
                    film.setTitle("new my-movie");
                    film.setRentalDuration((byte) 44);
                    film.setCategories(categories);
                    film.setReleaseYear(Year.now());
                    entityFilmDAO.create(film);

                    EntityFilmText filmText = new EntityFilmText();
                    filmText.setDescription("new fantasy");
                    filmText.setTitle("new my-movie");
                    filmText.setFilm(film);
                    filmText.setId(film.getId());
                    entityFilmTextDAO.create(filmText);

                    transaction.commit();

                    assertNotNull(film.getActors());
                    assertEquals(expectedRating, film.getRating());
                    assertTrue(film.getSpecialFeatures().contains(expectedFeature));
                    assertEquals(expectedLength, film.getLength());
                    assertNotNull(film.getLanguage());
                    assertNotNull(film.getOriginalLanguage());
                    assertEquals(expectedDescription, film.getDescription());
                    assertEquals(expectedTitle, film.getTitle());
                    assertEquals(expectedRentalDuration, film.getRentalDuration());
                    assertNotNull(film.getCategories());
                    assertEquals(expectedYear, film.getReleaseYear());

                    assertEquals(expectedDescription, filmText.getDescription());
                    assertEquals(expectedTitle, filmText.getTitle());
                    assertNotNull(filmText.getFilm());
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}