# <span style="color:Green">ViibeZon3</span>
#### <span style="color:white">Contributors</span>
 * Collins Odinga - Scrum Master
 * Levi Opunga
 * Joan Ndeng
 * Charles Muvaka


![Screenshot from 2022-05-20 08-00-57](https://user-images.githubusercontent.com/98308015/169454257-7f90f1eb-ffc4-4e46-9c51-0a7417633a8b.png)

## <span style="color:Greenyellow"> Prerequisites</span>

- Basic knowledge of On Git CLI
- Java 11
- Gradle as a built tool
- IntelliJ or any Java based IDE
- postgres SQL sever installed
- Postman desktop client installed

## <span style="color:Greenyellow">Technologies</span>

- Java 11
- Gradle
- Spark
- JUnit
- Postgres Sql

## <span style="color:Greenyellow">Installation</span>

1. Clone or download repository as an archive
2. If archive unzip the archive to get project folder
3. Open the application's root folder in an IDE that can execute builds in java using gradle e.g. IntelliJ or Eclipse.
4. Navigate to the Main.java file and run the `main` class
5. Use the link below to access the labeled request collection in Postman web,fork the collection into your personal workspace.
6. For testing use Postman desktop client to access the forked collection because their cloud client does not access
   local ports like `localhost:4567`.
7. In postman replace where indicated `:id` the number with the id you want to use in the path variables
8. Make sure you recreate the database in your local psql by running the psql commands above.
9. If you do not fork the already created postman collection make sure to enter and label yours correctly to avoid errors because of extra spaces or missing characters

## <span style="color:Greenyellow">Behaviour Driven Development</span>
* There is a form to collect data of a new Artist.
    * Input - Enter your Name.
    * Input - Enter Music Genre.
    * Input - Enter Artist Type.
    * Input - Enter Instrument best at.
    * Input - Select label to be associated with.
    * Output - Music artist saved in the database;

* There is a form to collect Information of creating a new Record Label.
    * Input - Enter Record label Name .
    * Input - Enter the manager  name.
    * Input - Enter the location of the label.
    * Output - Record label strored in the database;


## <span style="color:Greenyellow">Development</span>
 <p> Need to contribute?? Follow the following steps.</p>

* Fork the repo
* Create a new branch
 ```
  $ git switch -c (improve-feature)
  ```
* Make the required changes in the file.
* Add changes to reflect the changes made.
* Commit your changes.
  ```
  $ git commit -am (improve-feature)
  ```
* Push to the branch
  ```
  $ git push origin (improve-feature)
   ```
* Create a Pull Request

## Known Bugs
 <p>If you find any bug, open an issue <a href="https://github.com/Netiar/Viibezon3/issues">here</a> by including your search query and the expected result.</p>
 <p>Any suggestions or corrections to the code would highly be appreciated</p>

#### Live Link
<p>Below is a link to the live  site <a href="https://viibezone.herokuapp.com/artists">ViibeZone</a> </p>

## Reference
* Materialize CSS
  [Go Back to the top](#ViibeZon3)

## License
MIT License

Copyright (c) 2022 Collins Odinga

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
