package DEVOIR1
//
//abstract class Vehicule(var immatriculation: String, var marque: String, var modele: String, var kilometrage: Int,
//                        var disponible: Boolean=true){
//
//
//    open fun afficherDetails(){
//        println("Immatriculation : $immatriculation, Marque : $marque, Modele : $modele, Kilometrage : $kilometrage, Disponible? : $disponible")
//    }
//
//
//     fun estDisponible(): Boolean{
//         return disponible
//     }
//
//
//     fun marquerIndisponible(){
//         disponible = false
//     }
//
//
//     fun marquerDisponible(){
//         disponible = true
//     }
//
//
//     fun mettreAJourKilometrage(km: Int){
//         kilometrage = km
//     }
//}
//
//class Voiture(immatriculation: String, marque: String, modele: String, kilometrage: Int, disponible: Boolean, var nombrePortes: Int,
//              var typeCarburant: String): Vehicule(immatriculation, marque, modele, kilometrage, disponible){
//
//
//    override fun afficherDetails() {
//        super.afficherDetails()
//        println("Nombre Portes : $nombrePortes, Type Carburant : $typeCarburant")
//    }
//}
//
//
//class Moto(immatriculation: String, marque: String, modele: String, kilometrage: Int, disponible: Boolean,var cylindree: Int):
//    Vehicule(immatriculation, marque, modele, kilometrage, disponible) {
//
//
//    override fun afficherDetails() {
//        super.afficherDetails()
//        println("Cylindree : $cylindree")
//    }
//}
//
//class Conducteur(var nom: String, var prenom: String, var numeroPermis: String){
//    fun afficherDetails(){
//        println("Nom : $nom , Prenom : $prenom, Numero Permis : $numeroPermis")
//    }
//}
//
//
//class Reservation(var vehicule: Vehicule, var conducteur: Conducteur, var dateDebut: String, var dateFin: String,
//                  var kilometrageDebut: Int, var kilometrageFin: Int? = null){
//
//
//    fun cloturerReservation(kilometrageRetour: Int){
//        kilometrageFin = kilometrageRetour
//        vehicule.marquerDisponible()
//        vehicule.mettreAJourKilometrage(kilometrageRetour)
//    }
//
//
////    fun afficherDetails(){
////        println("Vehicule : ${vehicule.modele}, Conducteur : ${conducteur.nom}, Date Debut : $dateDebut, Date Fin : $dateFin , Kilometrage Debut : $kilometrageDebut, Kilometrage Fin : $kilometrageFin")
////
//
//    fun afficherDetails() {
//        println("---- Réservation ----")
//        println("Véhicule: ${vehicule.immatriculation} (${vehicule.marque} ${vehicule.modele})")
//        println("Conducteur: ${conducteur.prenom} ${conducteur.nom} | Permis: ${conducteur.numeroPermis}")
//        println("Début: $dateDebut  | Fin prévue: $dateFin")
//        println("Km début: $kilometrageDebut | Km fin: ${kilometrageFin ?: "Non renseigné"}")
//        println("---------------------")
//    }
//
//
//}
//
//
//class ParcAutomobile(var vehicules : MutableList<Vehicule> , var reservations : MutableList<Reservation>){
//
//
//    fun ajouterVehicule(vehicule: Vehicule){
//        vehicules.add(vehicule)
//    }
//
//
//
//    fun supprimerVehicule(immatriculation: String){
//        vehicules.forEach { ele -> if (ele.immatriculation == immatriculation){
//        vehicules.remove(ele)
//        }
//        }
//    }
//
//
//    fun reserverVehicule(immatriculation: String, conducteur: Conducteur, dateDebut: String, dateFin: String) {
//        vehicules.forEach { ele -> if (ele.immatriculation == immatriculation){
//         ele.marquerIndisponible()
//        }
//        }
//    }
//
//    fun afficherVehiculesDisponibles(){
//        vehicules.forEach { ele -> if (ele.disponible){
//        ele.afficherDetails()
//        }
//        }
//    }
//
//
//    fun afficherReservations(){
//        vehicules.forEach { ele -> if (!ele.disponible){
//            ele.afficherDetails()
//        }
//        }
//    }
//}
//
////Partie 4 : Gestion des Exceptions
//
//
//class VehiculeIndisponibleException(message: String): Exception(message)
//class VehiculeNonTrouveException(message: String): Exception(message)
//
//
//
//fun main(){
//
//
//    var voiture1 = Voiture("A-2334", "BMW", "2020", 500, true, 4, "essence")
//    var voiture2 = Voiture("V9988", "BMW", "2020", 500, true, 4, "essence")
//    var moto = Moto("B4566", "CIH", "2019", 100, true, 1210)
//
//
//    var vehicules = mutableListOf<Vehicule>()
//    var reservations = mutableListOf<Reservation>()
//    var parc = ParcAutomobile(vehicules , reservations)
//
//    parc.ajouterVehicule(voiture1)
//    parc.ajouterVehicule(voiture2)
//    parc.ajouterVehicule(moto)
//
//
//    var c1 = Conducteur("faysal", "elallaoui", "123")
//    var c2 = Conducteur("aymen", "zagnouni", "456")
//    var c3 = Conducteur("othmane", "edhane", "294")
//
//
//    parc.afficherVehiculesDisponibles()
//    parc.afficherReservations()
//
//
//    try {
//        val r1 = parc.reserverVehicule("V9988", c2, "10-10-2025", "20-10-2025")
//    } catch (e: Exception) {
//        println("Erreur réservation: ${e.message}")
//    }
//    try {
//        val r2 = parc.reserverVehicule("V9988", c2, "10-10-2025", "20-10-2025")
//    } catch (e: VehiculeIndisponibleException) {
//        println("Gestion d'erreur: ${e.message}")
//    } catch (e: Exception) {
//        println("Erreur réservation: ${e.message}")
//    }
//
//
//    try {
//        parc.reserverVehicule("B4566", c3, "10-10-2025", "20-10-2025")
//    } catch (e: VehiculeNonTrouveException) {
//        println("Gestion d'erreur: ${e.message}")
//    } catch (e: Exception) {
//        println("Erreur réservation: ${e.message}")
//    }
//    val r3 = try {
//        parc.reserverVehicule("A-2334", c1, "10-10-2025", "20-10-2025")
//    } catch (e: Exception) {  null  }
//
//    // 5. Afficher véhicules disponibles et réservations
//
//
//    parc.afficherVehiculesDisponibles()
//    parc.afficherReservations()
//
//
//    // 6. Clôturer une réservation : mettre à jour km et rendre disponible
//    // Prenons la première réservation (si elle existe)
//    val premiereReservation = parc.reservations.firstOrNull()
//    if (premiereReservation != null) {
//        println("\nClôture de la première réservation...")
//        premiereReservation.cloturerReservation(premiereReservation.kilometrageDebut + 450) // ajout de 450 km par exemple
//    }
//
//    // Afficher après clôture
//    parc.afficherVehiculesDisponibles()
//    parc.afficherReservations()
//
//    // Supprimer un véhicule (exemple)
//    parc.supprimerVehicule("GG-000-HH")
//
//    // Afficher état final
////    println("État final du parc :")
////    parc.vehicules.forEach { it.afficherDetails() }
//}

open class Personne(var nom: String, var pernom: String, var email: String) {

    // Fonction kataffichi les infos d'une personne

    open fun afficherInfos() {
        println("Nom : $nom , Prenom : $pernom , Email : $email")
    }

}

class Utilisateur(nom: String, pernom: String, email: String, var idUtilisateur: Int,
                  var emprunts: MutableList<Emprunt>) : Personne(nom, pernom, email) {


    // Fonction bach l’utilisateur ykhdem un emprunt dyal chi livre


    fun emprunterLivre(livre: Livre, dateEmprunt: String) {
        if (livre.disponiblePourEmprunt()) { // ila kayn stock
            val emprunt = Emprunt(this, livre, dateEmprunt) // nsawb un objet Emprunt
            if (this == emprunt.utilisateur){
                emprunts.add(emprunt) // nzido f liste
                livre.mettreAJourStock(livre.nombreExemplaires - 1)
            }
        }
    }




    // Fonction kataffichi kol les livres li 3nd utilisateur


    fun afficherEmprunts() {
        println("les emprunts de l'utilisateur: ${this.nom}")
        emprunts.forEach { ele ->
            if ( this== ele.utilisateur){
                ele.livre.afficherDetails()
            }
        }
    }
}


class Livre(var titre: String, var auteur: String, var isbn: String, var nombreExemplaires: Int) {


    // Kataffichi les infos dyal le livre


    fun afficherDetails() {
        println("Titre : $titre, Auteur : $auteur, ISBN : $isbn, Nombre Exemplaires : $nombreExemplaires")
    }


    // Katchecki wach kayn stock bach ymkn l’emprunt


    fun disponiblePourEmprunt(): Boolean {
        if (nombreExemplaires > 0) {
            return true
        } else { return false }
    }

    // Katmchi tbdl nombre d’exemplaires (mise à jour du stock)


    fun mettreAJourStock(nouveauStock: Int) {
        nombreExemplaires = nouveauStock
    }
}


class Emprunt(var utilisateur: Utilisateur, var livre: Livre, var dateEmprunt: String, var dateRetour: String? = null) {


    // Kataffichi les détails dyal l’emprunt


    fun afficherDetails() {
        println("Utilisateur : ${utilisateur.nom}, Livre : ${livre.titre}, Date Emprunt : $dateEmprunt, Date Retour : $dateRetour")
    }


    // Katmchi trj3 l-livre (mise à jour du stock w date retour)


    fun retournerLivre(date: String) {
        dateRetour = date
        livre.mettreAJourStock(livre.nombreExemplaires + 1)
    }


    fun ajouterEmprunt(list: MutableList<Emprunt>){
        list.add(this)
        livre.mettreAJourStock(livre.nombreExemplaires -1)
    }


}

abstract class GestionBibliotheque() {
    var utilisateurs: MutableList<Utilisateur> = mutableListOf()
    var livres: MutableList<Livre> = mutableListOf()


    abstract fun ajouterUtilisateur(utilisateur: Utilisateur)
    abstract fun ajouterLivre(livre: Livre)
    abstract fun afficherTousLesLivres()
}


class Bibliotheque : GestionBibliotheque() {


    override fun ajouterUtilisateur(utilisateur: Utilisateur) {
        utilisateurs.add(utilisateur)
    }

    override fun ajouterLivre(livre: Livre) {
        livres.add(livre)
    }

    override fun afficherTousLesLivres() {
        livres.forEach { ele -> ele.afficherDetails() }
    }



    // Recherche dyal livre b titre (ila ma tlach kayrj3 "Not found!!")


    fun rechercherLivreParTitre(titre: String): String {
        var liverRechercher = ""
        livres.forEach { ele ->
            if (ele.titre == titre) {
                liverRechercher = ele.titre
            } else {
                liverRechercher = "Not found!!"
            }
        }
        return liverRechercher
    }
}

fun main(){

    var bibliotheque = Bibliotheque()

    var emprunts = mutableListOf<Emprunt>()

    var l1 = Livre("deep book", "faysal", "2345", 20)
    var l2 = Livre("fullstack", "othmane", "2345", 20)
    var l3 = Livre("mobile", "aymen", "2345", 20)

    var u1 = Utilisateur("faysal", "elallaoui", "faysalelallaoui@gmail.com", 1, emprunts)
    var u2 = Utilisateur("aymen", "zagnouni", "aymenzgnouni@gmail.com", 2, emprunts)
    var u3 = Utilisateur("othman", "edahane", "othmaneedahane@gmail.com", 3, emprunts)

    var e1 = Emprunt(u1, l1, "1-10-2025", "20-10-2025")
    var e2 = Emprunt(u2, l1, "5-10-2025", "25-10-2025")
    var e3 = Emprunt(u3, l1, "10-10-2025", "30-10-2025")

    e1.ajouterEmprunt(emprunts)
    e2.ajouterEmprunt(emprunts)
    e3.ajouterEmprunt(emprunts)

    bibliotheque.ajouterLivre(l1)
    bibliotheque.ajouterLivre(l2)
    bibliotheque.ajouterLivre(l3)

    bibliotheque.ajouterUtilisateur(u1)
    bibliotheque.ajouterUtilisateur(u2)
    bibliotheque.ajouterUtilisateur(u3)

    println("--- Les informations des livres avant l'emprunt ---")
    bibliotheque.afficherTousLesLivres()

    u1.emprunterLivre(l1, "10-10-2025")
    u2.emprunterLivre(l1, "10-10-2025")

    println("--- Les informations des livres  ---")
    bibliotheque.afficherTousLesLivres()
    println("---------------------------------------")
    println("--- Les informations des l'utilisateurs ---")
    u1.afficherInfos()
    u2.afficherInfos()
    u3.afficherInfos()
    println("---------------------------------------")
    println("--- Les informations sur les emprunts ---")
    e1.afficherDetails()
    e2.afficherDetails()
    e3.afficherDetails()

    println("---------------------------------------")

    e1.retournerLivre("19-10-2025")

    println("---les informations des livres après le retour ---")
    l1.afficherDetails()

    println("---------------------------------------")

    println("--- Les emprunts de l'utilisateur ---")
    u1.afficherEmprunts()
    u2.afficherEmprunts()
    u3.afficherEmprunts()

    println("les livers ")
    bibliotheque.afficherTousLesLivres()

}

