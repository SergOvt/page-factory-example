# language: ru

Функционал: Тестирование поиска Yandex Market
  @ymtest
  Сценарий: Acer и Dell
    Когда открывается страница "Яндекс"
    И пользователь (нажимает на ссылку) "Маркет"
    Тогда открывается страница "Яндекс Маркет"
    Когда он в блоке "Категории" (нажимает на ссылку) с параметром "Компьютеры"
    Тогда открывается страница "Компьютеры"
    Когда он в блоке "Левое Меню" (нажимает на ссылку) с параметром "Планшеты"
    Тогда открывается страница "Ноутбуки"
    Когда он в блоке "Правое Меню" (устанавливает минимальную цену) с параметром "20000"
    Когда он в блоке "Правое Меню" (устанавливает максимальную цену) с параметром "25000"
    И он в блоке "Правое Меню" (нажимает элемент) с параметром "Acer"
    И он в блоке "Правое Меню" (нажимает элемент) с параметром "Показать всё"
    И он в блоке "Правое Меню" (ищет производителя) с параметром "DELL"
    И он в блоке "Правое Меню" (нажимает элемент) с параметром "DELL"
   # И он в блоке "Правое Меню" (нажимает элемент) с параметром "Свернуть"
    Тогда открывается страница "Результаты поиска"
    И (количество результатов поиска должно быть не менее) с параметром "8"
    Когда он (запоминает первый элемент в списке)
    И он в блоке "Меню поиска" (выполняет поиск по запомненному значению)
    Тогда открывается страница "Конкретный товар"
    И он (проверяет имя товара)