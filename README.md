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

<h2>Opis Gałęzi: Master</h2>
<p>W tej gałęzi została zaimplementowana aplikacja Java SE, która spełnia następujące warunki:</p>

- Zaimplementowano klasy kategorii i elementów, które są w relacji 1:n
- Zaimplementowano klasę DTO dla klasy elementów.
- Obiekty są tworzone tylko z wykorzystaniem builder'a.

<p>Zaimplementowane funkcjonalności:</p>

- Kolekcja kategorii jest zaludniana przy starcie aplikacji.
- Każda kategoria ma mieć po kilka elementów po starcie aplikacji.
- Używając pojedyńczego pipeline'a Stream API tworzony jest Set z elementami wszystkich kategorii.
- Używając pojedyńczego pipeline'a Stream API przefiltrowany został poprzedni wynik według wybranego kryterium i posortować wyniki według innego kryterium.
- Używając pojedyńczego pipeline'a Stream API przetransformowane są elementy utworzonego Set'u w listę obiektów DTO.
- Używając mechanizmu serializacji kolekcja kategorii jest zapisywana w serialization.bin, później jest ona odczytywana
i wypisywana.
- Używając współbieżnych pipeline'ów Stream API elementy każdej kategorii są wypisywane co 0.2 w osobnych wątkach.

<h2>Autor</h2>
Jakub Kinder (sigmor10)
