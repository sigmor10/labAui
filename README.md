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
<p>W tej gałęzi aplikacja została przeniesiona na Spring Framework, najważniejsze zmiany:</p>

- Zaimplementowane w poprzedniej gałęzi funkcjonalności zostały w większości usunięte.
- Dołączenie do projektu JPA i bazy danych H2.
- Uprzednio utworzone klasy zmieniono na klasy encyjne.
- Dodano repozytoria i klasy usług.
- Wprowadzanie danych na starcie aplikacji jest zrobione poprzez klasę Initializer.
- Dodano komunikację z użytkownikiem poprzez komendy w konsoli.

<p>Obecne funkcjonalności:</p>

- Zapis kategorii i elementów w bazie danych H2.
- Klasa Initializer wprowadza dane na starcie aplikacji.
- Na elementach kategorii można wykonywać operacje CRUD, na kategoriach nie można przeprowadzić operacji update.
- Komunikacja aplikacji z użytkownikiem poprzez prosty interfejs konsolowy i jego komendy.
- Obecnie można:

  - Wyświetlać listę kategorii.
  - Wyświetlić listę elementów ze wszystkich kategorii.
  - Wyświetlić listę elementów wybranej kategorii.
  - Dodać / usunąć kategorie.
  - Wykonać operacje CRUD na elementach

<h2>Autor</h2>
Jakub Kinder (sigmor10)
