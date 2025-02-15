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
    <td>Angular FrontEndk</td>
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

<h2>Opis Gałęzi: Master</h2>
<p>W tej gałęzi nastąpiło przejście z architektury monolitowej na architekturę mikrousługową, poniżej są pozostałe większe zmiany:</p>

- Podział aplikacji na: 
  - Aplikację kategorii
  - Aplikację elementów
  - Aplikację gateway
- Aplikacje komunikują się za pomocą REST API,
- Aplikacje kategorii i elementów mają osobne bazy danych H2.
- Utworzono klasy EventRepository w celu powiadomienia Aplikacji elementów o utworzeniu / usunięciu kategorii.
- Dane początkowe mają na sztywno przypisane identyfikatory.
- Usunięto możliwość komunikacji poprzez konsolę.

<p>Funkcjonalności w tej gałęzi pozostają takie same jak w poprzedniej za wyjątkiem komunikacji z użyciem konsoli, która zostałą usunięta</p>

<h2>Autor</h2>
Jakub Kinder (sigmor10)
