# tutorial-adprog-eshop
# Name: Muhamad Pascal Alfin Pahlevi
# NPM: 2206046752
# Exercise 1
## Reflection 1
Following the principles of coding practices, the first principle I thoroughly applied are meaningful names. In order to distinguish the different classes in the code, I made sure to use words such as "update", "edit". and "delete" instead simple letters like a,b,c. Though both ways of naming are not wrong, using more distinctive names would enhance code readability especially for bigger projects. Aside from that, the code is also organized into multiple functions, differentiating each one with their own respective roles which allows a clearer code. 

In the case of secure coding practices, input validation was applied for the "productId" parameter in order to prevent common security issues. Aside from that, the productId for each generated product is created using UUID's which randomly generates hence reducing predictability. 

However, when it comes to my code, I do believe that some improvements may still be done to improve it overall. For one, since I generally focused on the function of the code, I neglected the idead to implement error handling. Due to this, in the event that an unexpected error occurs, it may be harder to examine the issues, leading to higher time consumption when fixing them. 

## Reflection 2
1. The unit test is definitely very useful in testing out the functions of the written code. I believe the amount of unit tests that should be made is dependant on how many functions the website would have. Thus, if the website has more functions more tests would be needed and less if there are not that much functions. Having 100% code coverage does not necesarrily mean that our code has no bugs or errors. Though it means that every single line of your code has been tested to work properly, there are still chances that our unit tests do not fully test out the code and hence could still lead to some bugs or errors.

2. If I were to create another functional test suite that verifies the number of items in the product list with the same setup procedures and instance variables to the prior code, it could create and easily approachable environment in the sense of code familiarity. Since I would be used to the code, it would be much easier for me if I wanted to make slight variations in order to suit my new needs. However, this would only be the case if I was completely sure that the prior code was already correct and had no issues whatsoever because if I were to reuse code containing multiple errors, this would instead make my life harder as I would then have to use more of my time to debug and fix any errors. Above all, I would say that an important issue with reusing code is that I would have to carefully look through the code making sure that my classes are different from one another or risk the issue with code duplication.

# Exercise 2
# Reflection 4.2
1. One code quality issue that I fixed was in "ProductRepository.java' where I had a case in which I used a for loop but the code scanner recommended for me to use a for each loop. There were quite a few ways in which I approached this issue, the first one being to simply use the built in fix provided by Intellij. The other fix was of course to figure it out on my own. Personally, I did both as I was curious on how I would have done as compared with how intellij would have fixed it. However, aside from fixing the actual code quality issue, before all of that, I also had to figure out a way for github to actually scan and find these issues. In order to do so, I decided to make use of pmd, a code scanning tool provided by github, in which all I had to do was set it up by adding a new workflow namde 'pmd.yml'.

2. After looking through the CI/CD workflows on Github, I would say that the current implementation has met the definition of Continuous Integration and Continuous Deployment. To begin with, the workflows implemented in the GitHub continuously scans the code pushed into the repository, providing fix recommendations. In terms of continuous development, the repository is deployed to koyeb where each push would run a deployment or redeployment on koyeb.


