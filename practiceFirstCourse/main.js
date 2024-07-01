const readline = require("readline-sync");

const { database } = require("./database/index");
const deleteAllStudents = require("./functions/removeStudents");
const displayStudents = require("./functions/displayStudents");
const displayAvgGroupStudents = require("./functions/displayAvgGroupStudents");
const addStudent = require("./functions/addStudent");

(async () => {
  console.clear();

  try {
    await database.sync({ alter: true });
    console.log("[DATABSE] Connection has been established successfully.");
  } catch (error) {
    console.error("[DATABSE] Unable to connect to the database:", error);
    process.exit(1);
  }

  while (true) {
    console.log("\nMenu:");
    console.log("1) Display students filtered by group number.");
    console.log("2) Display students filtered by avg grade.");
    console.log("3) Add a new student.");
    console.log();
    console.log("9) [DEBUG] Delete all students.");
    console.log("0) Close program.");
    const choice = readline.questionInt("Enter your choice: ");

    console.clear();
    switch (choice) {
      case 1:
        await displayStudents();
        break;
      case 2:
        await displayAvgGroupStudents();
        break;
      case 3:
        await addStudent();
        break;
      case 9:
        await deleteAllStudents();
        break;
      case 0:
        console.log("Exiting the program...");
        process.exit(1);
      default:
        console.log("Invalid choice. Please enter a number from 1 to 3.");
    }
  }
})();
