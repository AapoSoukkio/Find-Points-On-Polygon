# Project: Polygon Point Comparison

Made by: Aapo Soukkio

***

## About the project

This program compares a set of points to a polygon and checks whether the points are inside, outside or on the edge of the polygon.
The program will create two text files "polygoni.txt" and "pisteet.txt" with the polygon and points coordinates and will create a third file "selvitys.txt" where the results of the comparison will be written.

### How to run the project

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

##### Prerequisites

- Java 8 or later
- A text editor or an IDE

To run both the Web API and the Blazor client app:

1. Clone the repository to your local machine.
2. Open the project in your text editor or IDE
3. Build and run the project

## Build With

- Java - The programming language used

### Limitations

This is the first version of the program and it is not functioning perfectly.
The current implementation uses a simple approach to check whether the points
are inside or outside the polygon by comparing the coordinates of the points to
the maximum and minimum coordinates of the polygon. This approach may not work for all
cases and may produce inaccurate results for certain types of polygons. A more robust
way to check if a point is inside a polygon is to use the ray casting algorithm.
This will be implemented in the future versions of the program.

## Helpful Links

> **Following material will help to understand this project and learn more about Java.**


1. [Learn Java Programming](https://www.programiz.com/java-programming)
2. [What is a Polygon?](https://www.splashlearn.com/math-vocabulary/geometry/polygon)
