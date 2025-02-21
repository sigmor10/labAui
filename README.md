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

<h2>Opis Gałęzi: lab6</h2>
<p>W tej gałęzi nastąpiły zmiany ukierunkowane na konteneryzacje z użyciem technologii Docker:</p>

- Utworzone zostały pliki dockerfile dla każdej mikro usługi zawierających podstawową konfigurację aplikacji.
- Utworzone zostały artefakty każdej z aplikacji.
- Utworzone zostały skrypty bash do automatycznego tworzenia artefaktów i obrazów.
- Utworzony został plik docker-compose do automatycznego utworzenia i połączenia kontenerów aplikacji.
- Wydzielone zostały osobne kontenery na bazy danych dla usług kategorii i elementów.


<h2>Autor</h2>
Jakub Kinder (sigmor10)
