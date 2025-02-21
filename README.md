<h2> Opis projektu</h2>

<h3>Repozytorium zawiera etapowy rozwój aplikacji typu CRUD, zaczynając od zwykłej aplikacji Java. W każdej kolejnej gałęzi dodawane/zmieniane są funkcjonalności aplikacji zaczynając od dodania Spring framework.</h3>

<h2>Spis gałęzi</h2>

<table>
  <tr>
    <td>Gałąź</td>
    <td>Najważniejsze zmiany</td>
  </tr>
  
  <tr>
    <td>master</td>
    <td>Klasyczna aplikacja Java</td>
  </tr>
  
  <tr>
    <td>lab2</td>
    <td>Spring framework</td>
  </tr>
  
  <tr>
    <td>lab3</td>
    <td>REST API</td>
  </tr>
  
  <tr>
    <td>lab4</td>
    <td>Architektura mikrousługowa</td>
  </tr>
  
  <tr>
    <td>lab5</td>
    <td>Angular FrontEnd</td>
  </tr>
  
  <tr>
    <td>lab6</td>
    <td>Docker</td>
  </tr>
  
  <tr>
    <td>lab7</td>
    <td>Discovery, Configuration</td>
  </tr>
</table>

<h2>Opis Gałęzi: lab7</h2>
<p>W tej gałęzi aplikacja została rozwinięta o bardziej zaawansowane elementy wdrożeniowe:</p>

- Dodano usługę serwera konfiguracji.
- Dodano pliki konfiguracyjne dla każdej z usług (kategorii, elementów i gateway).
- Dodano usługę serwera Discovery (Eureka).
- Zmodyfikowano usługi tak, aby pobierały konfiguracje z usługi serwera konfiguracji.
- Zmodyfikowano usługi tak, aby były rejestrowane w usłudze serwera Discovery.
- Zmodyfikowane wszystkie usługi tak, aby wykorzystywały serwer Discovery do odnajdywania usługi-odbiorcy.
- Zmodyfikowano plik docker-compose tak, aby działały dwie instancje usługi elementów.
- Zmodyfikowano usługę elementów tak, aby zapisywała w logach, że wykonała daną czynność. (potrzebne do sprawdzenia, czy obie instancje są wykorzystywane)

<h2>Autor</h2>
Jakub Kinder (sigmor10)
