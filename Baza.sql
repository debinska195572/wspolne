

CREATE TABLE IF NOT EXISTS `Menu_DB`.`Users` (
  `Login` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Age` INT UNSIGNED,
  `Height` INT UNSIGNED,
  `Weight` INT UNSIGNED,
  `Lactose tolerance` boolean,
  `Intolerance to gluten` boolean,
  `Diet` varchar(45),
  PRIMARY KEY (`Login`),
  UNIQUE INDEX `Login_UNIQUE` (`Login` ASC),
  CHECK (`Diet` like `Normal` or `Diet` like `Vegetarian` or `Diet` like `Vegan`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Menu_DB`.`Recipes` (
  `ID_Recipe` INT unsigned NOT NULL auto_increment,
  `Dish_Name` VARCHAR(45) NOT NULL,
  `Owner` varchar (45) NOT NULL,
  `Content` varchar(45),
  PRIMARY KEY (`ID_Recipe`),
  foreign key (`Owner`) REFERENCES Users(Login),
  UNIQUE INDEX `Recipe_UNIQUE` (`ID_Recipe` ASC))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Menu_DB`.`Ingredients` (
  `Ingredient_Name` VARCHAR(45) NOT NULL,
  `Lactose` boolean,
  `Gluten` boolean,
  `Calories` varchar (10),
  `Meat` boolean,
  PRIMARY KEY (`Ingredient_Name`),
  UNIQUE INDEX `Ingredient_Name_UNIQUE` (`Ingredient_Name` ASC))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `Menu_DB`.`RecipesIngredients` (
  `ID_RecipeIngredient` INT unsigned NOT NULL auto_increment,
  `Recipe_Number` INT unsigned NOT NULL,
  `Ingredient_Name`  VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_RecipeIngredient`),
  foreign key (`Recipe_Number`) REFERENCES Recipes(ID_Recipe),
foreign key (`Ingredient_Name`) REFERENCES Ingredients(Ingredient_Name),
  UNIQUE INDEX `Ingredient_UNIQUE` (`ID_RecipeIngredient` ASC))
ENGINE = InnoDB;


