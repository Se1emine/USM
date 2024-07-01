const { Student } = require("../database/student");
const readline = require("readline-sync");

module.exports = async () => {
  try {
    let validInput = false;
    let lastName, firstName, group, grades;
    while (!validInput) {
      lastName = readline.question("Enter last name: ").toUpperCase();
      if (!/^[a-zA-Z]+$/.test(lastName)) {
        console.log("Last name must contain only letters.");
        continue;
      }
      firstName = readline.question("Enter first name: ").toUpperCase();
      if (!/^[a-zA-Z]+$/.test(firstName)) {
        console.log("First name must contain only letters.");
        continue;
      }
      group = readline.question("Enter group number (IA 2305): ").toUpperCase();
      if (!/^[a-zA-Z]{1,2} \d{4}$/.test(group)) {
        console.log('Group must be a example like "AI 2404".');
        continue;
      }
      grades = [];
      for (let j = 0; j < 5; j++) {
        const grade = readline.questionInt(`Enter grade ${j + 1}: `);
        if (!Number.isInteger(grade) || grade < 1 || grade > 10) {
          console.log("Grade must be an integer between 1 and 10.");
          grades = [];
          break;
        }
        grades.push(grade);
      }
      if (grades.length === 5) {
        validInput = true;
      }
    }

    await Student.create({
      lastName,
      firstName,
      group,
      grades: grades.join(","),
    });
    console.clear();
    console.log("New student added successfully!");
  } catch (error) {
    console.log("Something wrong:", error);
  }
};
