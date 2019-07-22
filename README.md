## PROBLEM
  Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that 
  produces the minimum number of ranges required to represent the same restrictions as the input.
  
## How to run the app
### Run with the default data:
  - run <code>./gradlew clean shadowJar</code> in the root folder.
  - run <code>java -jar zipcode-1.0-all.jar</code> in the folder with the generated .jar file (`build/libs`).
  - `result.txt` file would be generated with a results.
  
### Run with your data:
You can configurate input and output files in the `resources/config.cfg` file:
- `inputFilePath`: Input file path.
- `outputFile`: Output file name.

Also you can just paste your data in the `resources/input.txt` file.
  
