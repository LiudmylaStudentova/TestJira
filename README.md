Установка Maven проекта и запуск теста:

1.Создаём проект в IntelliJ Idea

2.Выбираем Maven

3.Вставляем код

4.Подклчаем библиотеки, в xml file проекта прописываем <dependency> // это позволит подкачивать всегда новые библиотеки для теста

 <dependencies>
            <dependency>
            <groupId>org.seleniumhq.selenium</groupId>// взаимодействие с браузером
            <artifactId>selenium-java</artifactId>
            <version>3.141.5</version>
        </dependency>
            <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.14.3</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>3.7.1</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>// TestTNG превращает java метод в тест
            <artifactId>testng</artifactId>
            <version>7.0.0-beta7</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.0.0-beta7</version>
            <scope>compile</scope>
        </dependency>
        
    </dependencies>

