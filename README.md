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


# Exercise 3
## Reflection
1. From all the principles in SOLID, the ones that I applied into my project are the Single Responsibility Principle (SRP), the Open-Closed Principle (OCP), the Liskov Substitution Principle (LSP), and the Interface Segregation Principle (ISP). SRP dictates that each Java class should execute only one function and in my case I decided to apply this concept to the models in my code. In order to do so, I created a new java class named `Object` wherein I decided to put all common attributes between the `Car` and `Product` model. OCP dictates that a software artifact should be open for extension but closed for modification. This was applied to my code, by implementing `ProductRepoInterface` that extends `ProductRepository` because it allows for extension without modification. LSP ensures that eny child class can be used interchangeably with its parent class without causing unexpected behaviour. This can also be seen in `Product` and `Car` because when their instances are substituted with those in `Object`, it would not cause the code any unexpected behaviour. Finally, ISP ensures that implementing classes are only burdened with methods pertinent to their functionality hence why this principle can be seen in both the `CarRepoInterface` and `ProductRepoInterface` classes because each of these classes are designed with methods specific to either `Car` or `Product`.

2. There are quite a few advantages from applying the SOLID principles to my project. To begin with, classes that adhere to SRP would be easier to understand and maintain which was seen through the addition of the `Object` class. In addition to this, with the Open-Closed Principle, the code itself would become both more flexible and extensible since additional functions can simply be added through implementations instead of changing existing code. This was seen with the addition of `ProductRepoInterface` and `CarRepoInterface`. Aside from that, LSP allows more flexibility with the code as classes and subclasses can be used interchangeably, in my case, through the classes `Product`, `Car`, and `Object`. Finally, with ISP, we would have much cleaner interfaces because they would not contain unused methods. Overall, through the SOLID principles, my code would be easier to maintain and more adapatable to change. It also promotes good coding practice, which in the end, would increase the quality of the code itself.

3. Not sticking to SOLID principles in the provided code has some significant problems. It makes the system harder to handle and expand, causing potential issues in different parts of the program when changes are made. For instance, in the `CarRepository` class, directly changing things without using a proper method violates the rule of making the system open for adding new features and closed for modifying existing code. This messes up the system's ability to adapt to changes. The Service classes (`CarServiceImpl` and `ProductServiceImpl`) show that adding new features might force direct changes, making it challenging for future developers to work on and enhance the program. Ignoring SOLID principles also poses a risk of things getting mixed up, making the code more challenging to understand, fix, and maintain. This lack of modularity also hampers the reuse of code, like the `Item` model, for other products, adding complexity and making it more challenging to manage. Overall, neglecting SOLID principles brings about complexities in code management, decreases adaptability to changes, and increases the likelihood of issues in the long run.

# Exercise 4
## Reflection
1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests.

* Do I have enough functional tests to reassure myself that my application really works, from the point of view of the user? 

I do not think that I have enough functional tests because I have not implemented tests for everything in my code. I hvae currently only made tests for the Product model, however there are still some other models within my code hencewhy I would still need to make more functional tests to reassure myself that the applicatoin really works.

* Am I testing all the edge cases thoroughly?

Personally, I do think that I have managed to test all the edge cases thoroughly. Aside from testing whether the features work, I have also taken into account any possible errors that may be encountered when running the code, like the appearance of null values, or perhaps even unsupported formats. Due to this, making both a Happy and Unhappy test case should be a good way of testing all the edge cases thoroughly.

* Do I have tests that check whether all my components fit together properly? Could some integrated tests do this, or are functional tests enough?

I believe that my tests check the compatibility between components properly. I also think both integrated tests and functional tests are a good way of doing so, however, I am not sure whether I have created these tests enough to fully check which tests are better for the job.

* Are my tests giving me the confidence to refactor my code, fearlessly and frequently?

I personally do think that these tests are giving me the confidence to refactor my code. Aside from the constant practice that I am getting, by following the TDD workflow, I am motivating myself to fix errors and optimize the code I am creating as much as I can. Aside from this, creating tests also give me an all-around idea on how my code works, further helping me think about what I should maybe add to fix problems .

* Are my tests helping me to drive out a good design? If I have a lot of integration tests but less unit tests, do I need to make more unit tests to get better feedback on my code design?

I would say that it does because by creating these tests, I am getting a general idea on how my code works, how I can implement its features further, as well as take into account the many errors I might run into. Even if I do have more integraton tests than unit tests, I do still think that unit tests are just as important so I believe making more will give me better feedback.

* Are my feedback cycles as fast as I would like them? When do I get warned about bugs, and is there any practical way to make that happen sooner?

I think my feedback cycles are fast enough for me. When getting warned about bugs, I would say the most practical way to make it happen sooner would maybe to implementing more comprehensive unit tests, specific to indiviudal functions or methods. In doing so, I would be able to catch bugs early on in the development cycle.

* Is there some way that I could write faster integration tests that would get me feedback quicker?

I currently do not think that there is any way to create integration tests. Mainly because I have not had the chance to implement any integration tests yet.

* Can I run a subset of the full test suite when I need to?

I would be able to do so because I created multiple tests, those of which are separate for the different layers in my code. This means that I can freely choose the test I wish to run specifically without needing to run every single test at once every time.

* Am I spending too much time waiting for tests to run, and thus less time in a productive flow state?

Personally, I feel like it depends on how many tests I might have to implement based on how many features I have. Although, I do feel that when creating the tests, considering that I might have to make happy and unhappy cases, there might be times where I am to focused on making the tests themselves instead of improving on the functionality of the code. In my opinion, this would be highly unproductive because if this keeps on going, I would have a much longer time in creating a finished product.

2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.

F : All my tests can be ran pretty quickly as it only takes a few seconds. <br>
I : My tests should not affect any of the other test and can be run individually. <br>
R : Each test is repeatable since the method is set up each time before it starts. <br>
S : Each test has their own assert cases which validates the outputs I had want to test beforehand. <br>
T : I believe that I have considered many cases for both happy and unhappy, making sure the testing is thorough. <br>






