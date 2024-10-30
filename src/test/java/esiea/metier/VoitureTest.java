package esiea.metier;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class VoitureTest {

    @Test
    void testToString() {
        Voiture voiture = new Voiture();
        voiture.setId(1);
        voiture.setMarque("Renault");
        voiture.setModele("Clio");
        voiture.setFinition("Clio 4");
        voiture.setCarburant(Voiture.Carburant.ESSENCE);
        voiture.setKm(10000);
        voiture.setAnnee(2018);
        voiture.setPrix(10000);
        assertEquals("{\"id\":1,\"marque\":\"Renault\",\"modele\":\"Clio\",\"finition\":\"Clio 4\",\"carburant\":\"ESSENCE\",\"km\":10000,\"annee\":2018,\"prix\":10000}", voiture.toString());
    }

    @Test
    void check() {
        Voiture voiture = new Voiture();
        voiture.setId(-1);
        assertFalse(voiture.check(), "Car id cannot be negative");
        voiture.setId(1);

        voiture.setMarque("");
        assertFalse(voiture.check(), "Car marque cannot be empty");
        voiture.setMarque("Renault");

        voiture.setModele("");
        assertFalse(voiture.check(), "Car modele cannot be empty");
        voiture.setModele("Clio");

        voiture.setFinition("");
        assertFalse(voiture.check(), "Car finition cannot be empty");
        voiture.setFinition("Clio 4");

        voiture.setCarburant(null);
        assertFalse(voiture.check(), "Car carburant cannot be empty");
        voiture.setCarburant(Voiture.Carburant.ESSENCE);

        voiture.setKm(-1);
        assertFalse(voiture.check(), "Car km cannot be negative");
        voiture.setKm(10000);

        voiture.setAnnee(-1);
        assertFalse(voiture.check(), "Car annee cannot be negative");

        voiture.setAnnee(3000);
        assertFalse(voiture.check(), "Car annee cannot be in the future");
        voiture.setAnnee(2018);

        voiture.setPrix(-1);
        assertFalse(voiture.check(), "Car prix cannot be negative");
        voiture.setPrix(10000);

        assertTrue(voiture.check(), "Car is valid");
    }

    @Test
    void getTypeDonnee() {
        assertEquals("string", Voiture.getTypeDonnee("marque"), "marque is a string");
        assertEquals("string", Voiture.getTypeDonnee("modele"), "modele is a string");
        assertEquals("string", Voiture.getTypeDonnee("finition"), "finition is a string");

        assertEquals("entier", Voiture.getTypeDonnee("id"), "id is an int");
        assertEquals("entier", Voiture.getTypeDonnee("annee"), "annee is an int");
        assertEquals("entier", Voiture.getTypeDonnee("km"), "km is an int");
        assertEquals("entier", Voiture.getTypeDonnee("prix"), "prix is an int");

        assertEquals("", Voiture.getTypeDonnee("test"), "test does not exist");
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class CarburantTest {

        @Test
        void get() {
            assertEquals(Voiture.Carburant.ESSENCE, Voiture.Carburant.get("E"), "ESSENCE is a carburant");
            assertEquals(Voiture.Carburant.DIESEL, Voiture.Carburant.get("D"), "DIESEL is a carburant");
            assertEquals(Voiture.Carburant.ELECTRIQUE, Voiture.Carburant.get("W"), "ELECTRIQUE is a carburant");
            assertEquals(Voiture.Carburant.HYBRIDE, Voiture.Carburant.get("H"), "HYBRIDE is a carburant");
        }
    }
}