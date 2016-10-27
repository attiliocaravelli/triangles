# Triangle challenge

Write a program that will determine the type of a triangle. 
It should take the lengths of the triangle's three sides as input, 
and return whether the triangle is equilateral, isosceles or scalene.

Usage: triangle sideA sideB sideC 

Modeling the problem
1. input data: decimal -> BigDecimal
2. two model classes: Triangle and TriangleType
3. TriangleType is an enumeration of potential triangle types
4. Triangle -> validates the parameters in input and in case
			   throw a runtime exception with a specific error message
5. Error messages are declared as constants in the class Triangle  

Assumptions: 
1. input data can be decimal - format d.dd - ignoring more two decimal numbers
2. cli application

Methodology of development: TDD
1. TriangleType is only an enumeration of constant types - no logic inside
2. TriangleTest provides mainly two kind of tests:
   - basic tests
   - edge cases  
3. Any methods of the utility classes are tested singularly

Potential expansions:
1. Log and internationalization error messages (not required in this step)

Math and String utilities have been created in order to no call methods from the constructor 