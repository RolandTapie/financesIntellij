package talla.fin.projet.Services.FluxFinanciers.Services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import talla.fin.projet.Configuration.Configs;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Compte;
import talla.fin.projet.Repositories.FluxFinanciers.CodaRepository;
import talla.fin.projet.Repositories.FluxFinanciers.CompteRepository;
import talla.fin.projet.Services.FluxFinanciers.Interfaces.ILectureCoda;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class LectureCodaTest {

    @Autowired
    public CodaRepository codaRepository;

    @Autowired
    public CompteRepository compteRepository = new CompteRepository() {
        @Override
        public List<Compte> findByCompte(String compte) {
            return null;
        }

        @Override
        public List<Compte> findAll() {
            return null;
        }

        @Override
        public List<Compte> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Compte> findAllById(Iterable<Integer> integers) {
            return null;
        }

        @Override
        public <S extends Compte> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Compte> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Compte> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Compte> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Compte getOne(Integer integer) {
            return null;
        }

        @Override
        public Compte getById(Integer integer) {
            return null;
        }

        @Override
        public <S extends Compte> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Compte> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Compte> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Compte> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Compte> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(Compte entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Integer> integers) {

        }

        @Override
        public void deleteAll(Iterable<? extends Compte> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Compte> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Compte> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Compte> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Compte> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Compte, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

    ILectureCoda lectureTest = new LectureCoda(compteRepository, codaRepository);
    ILectureCoda lectureCodaMock = Mockito.mock(LectureCoda.class);

    Configs configs = new Configs();
    String cheminTest = configs.lecture();

    LectureCodaTest() throws FileNotFoundException {
    }

    @BeforeEach
    void setUp() throws FileNotFoundException {
        System.out.println("Debut des Tests");
        System.out.println("Lecture du fichier de configuration");

    }

    @AfterEach
    void tearDown() {
        System.out.println("Fin des Tests");
    }

    @Test
    void controleEtImport() {
        System.out.println("le chemin : " + cheminTest);
        lectureTest.ControleEtImport(cheminTest);
        System.out.println("Nombre total de lignes :" + lectureTest.getNbligne());
        System.out.println("somme totale : " + lectureTest.getAmount());
        assertEquals(1008,lectureTest.getNbligne());
    }
}