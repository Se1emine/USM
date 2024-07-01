const { Student } = require("../database/student");

module.exports = async () => {
  try {
    await Student.destroy({ truncate: true });
    console.log("All students have been deleted from the database.");
  } catch (error) {
    console.log("Something wrong:", error);
  }
};
