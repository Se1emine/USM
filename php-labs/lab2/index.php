<?php
date_default_timezone_set('Europe/Chisinau');

$day = date('l'); 

if ($day == 'Monday' || $day == 'Wednesday' || $day == 'Friday') {
    $john_schedule = '8:00-12:00';
} else {
    $john_schedule = 'Нерабочий день';
}

if ($day == 'Tuesday' || $day == 'Thursday' || $day == 'Saturday') {
    $jane_schedule = '12:00-16:00';
} else {
    $jane_schedule = 'Нерабочий день';
}

echo "<table border='1' cellpadding='5'>";
echo "<tr><th>№</th><th>Фамилия Имя</th><th>График работы</th></tr>";
echo "<tr><td>1</td><td>John Styles</td><td>$john_schedule</td></tr>";
echo "<tr><td>2</td><td>Jane Doe</td><td>$jane_schedule</td></tr>";
echo "</table>";
?>

<h2>Цикл for</h2>
<?php
$a = 0;
$b = 0;

for ($i = 0; $i <= 5; $i++) {
    $a += 10;
    $b += 5;
    echo "Шаг $i: a = $a, b = $b<br>";
}

echo "<strong>Конец цикла: a = $a, b = $b</strong>";
?>

<hr>

<h2>Цикл while</h2>
<?php
$a = 0;
$b = 0;
$i = 0;

while ($i <= 5) {
    $a += 10;
    $b += 5;
    echo "Шаг $i: a = $a, b = $b<br>";
    $i++;
}

echo "<strong>Конец цикла: a = $a, b = $b</strong>";
?>

<hr>

<h2>Цикл do-while</h2>
<?php
$a = 0;
$b = 0;
$i = 0;

do {
    $a += 10;
    $b += 5;
    echo "Шаг $i: a = $a, b = $b<br>";
    $i++;
} while ($i <= 5);

echo "<strong>Конец цикла: a = $a, b = $b</strong>";
?>

