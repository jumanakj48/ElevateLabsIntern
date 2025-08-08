# 📂 File Handling in Java – Example

This program demonstrates basic **file handling** in Java, including creating, writing, and reading from a file using `File`, `FileWriter`, and `BufferedReader`.

---

## 📜 Features

1. **📝 File Creation**
   - Checks if `test.txt` exists in the `day4` directory.
   - Creates the file if it does not exist.

2. **✍️ Writing to a File**
   - Uses `FileWriter` to write:
     ```
     Writing to the test.txt file...
     ```
   - Closes the writer to save changes.

3. **📖 Reading from a File**
   - Uses `BufferedReader` with `FileReader` to read the file content **line-by-line**.
   - Prints each line to the console.

4. **⚠️ Error Handling**
   - Catches exceptions like:
     - `IOException` for file operations.
     - `FileNotFoundException` for missing files.
   - Prints error messages **without stopping program execution**.

---
