# language: ru

Функция: Reqres new User (Cucumber)

  Сценарий: Создание нового пользователя
    Дано чтение пользователя из файла 'src/test/resources/user.json'
    Когда изменяем имя пользователя на 'Tomato' и профессию на 'Eat maket'
    Тогда создаем нового пользователя