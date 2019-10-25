# TestJira
###Установка Maven проекта и запуск теста:
#####1.Создаём проект в IntelliJ Idea
#####2.Выбираем Maven
#####3.Вставляем код
#####4.Подклчаем библиотеки, в xml file проекта прописываем <dependency> // это позволит подкачивать всегда новые библиотеки для теста
```
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
```

   ##### 5.Обьявляем java class - это наш тестовый suit, который будет хранить более одного автотеста
   #####6.Прописываем путь к chromedriver: это позволит браузеру понимать команды с нашего java code(Изначально разещаем в корень проекта)
   ```     
        public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
  ```
   #####7.Обьявляем java метод @Test -это то, что framework TestNG должен себе положить в память и начать запускать
   ##### 8.Запускаем тест


#####Алгоритм для подключения Allure
#####1. обновить pom.xml
-добавить dependency
```
  <dependency>
        <groupId>io.qameta.allure</groupId>
         <artifactId>allure-testng</artifactId>
          <version>2.12.0</version>
  </dependency>
добавить plugins
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.20</version>
            <configuration>
                <suiteXmlFiles>
                    <suiteXmlFile>TestNG.xml</suiteXmlFile>
                </suiteXmlFiles>
                <argLine>
                    -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                </argLine>
            </configuration>
            <dependencies>
                <dependency>
                    <groupId>org.aspectj</groupId>
                    <artifactId>aspectjweaver</artifactId>
                    <version>${aspectj.version}</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
добавить properties
 <properties>
        <aspectj.version>1.8.10</aspectj.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
 ```
    
#####добавить TestNG.xml в корень проекта (что бы явно указать какие тесты и как запускать, не параллельно)
 ```
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Parallel test suite" >
    <test name="Issue">
        <classes>
            <class name="JIRATest"/>
        </classes>
    </test>
</suite>
 ```
#####обновить тест - добавить @Feature
2. установить Allure CLI
https://docs.qameta.io/allure/#_installing_a_commandline
3. запустить тесты
mvn clean test

4. выполнить в корне проекта консольную команду и получить отчет
```allure generate```
Отчет будет в корне проекта в папке "allure-report"


