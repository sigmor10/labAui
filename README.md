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

<h2>Opis Gałęzi: lab3</h2>
<p>W tej gałęzi zostały zaimplementowane kontrolery wykorzystujące REST API, oto najważniejsze zmiany:</p>

- Dodano plik request.http zawierający żądania http do testowania REST API.
- Dodano klasy DTO dla obu klas encyjnych.
- Dodano klasy funkcyjne w celu transformacji klas encyjnych na DTO i odwrotnie.

<p>Nowe funkcjonalności w tej gałęzi:</p>

- Komunikacja z aplikacją poprzez REST API.
- Poprawne odpowiedzi w razie braku żądanych elementów / kategorii.
- Transformacja przychodzących obiektów z klas DTO na klasy encyjne.
- Transformacja klas encyjnych na DTO w celu ich wysłania w odpowiedzi.
- Poprawne rozróżnianie kategorii z pustą listą elementów a brakiem kategorii i odpowiednia odpowiedź w obu przypadkach w przypadku żądań http o listę elementów kategorii.

<h2>Autor</h2>
Jakub Kinder (sigmor10)
