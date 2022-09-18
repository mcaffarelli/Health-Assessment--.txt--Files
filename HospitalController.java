import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HospitalController {

    
    @FXML
    private TextField BloodPressureText;

     @FXML
    private TextField WeightBMI;
     
     @FXML
    private TextField HeightBMI;

    @FXML
    private TextField GlucoseText;

    @FXML
    private TextField TriglyceridesText;

    @FXML
    private TextField HDLText;

    @FXML
    private TextField LDLText;

    @FXML
    private TextField PatientNameText;
    
    @FXML
    private Button GetReultsButton;

    @FXML
    private Button GetPatientButton;

    @FXML
    private Button ClearButton;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField ResultsBloodPressure;

    @FXML
    private TextField ResultsBMI;

    @FXML
    private TextField ResultsLDL;

    @FXML
    private TextField ResultsHDL;

    @FXML
    private TextField ResultsTriglycerides;

    @FXML
    private TextField ResultsBloodGlucose;
    
    @FXML
    private TextField TotalText;

    @FXML
    private TextField RetultsTotal;
    
    @FXML
    private TextField ReportText;

    @FXML
    private Button SaveReportButton;

    @FXML//Clear all Text
    void ClearButtonPressed(ActionEvent event) {
        BloodPressureText.clear();
        HeightBMI.clear();
        WeightBMI.clear();
        GlucoseText.clear();
        TriglyceridesText.clear();
        HDLText.clear();
        LDLText.clear();
        PatientNameText.clear();
        ResultsBloodPressure.clear();
        ResultsBMI.clear();
        ResultsLDL.clear();
        ResultsHDL.clear();
        ResultsTriglycerides.clear();
        ResultsBloodGlucose.clear();
        RetultsTotal.clear();
        TotalText.clear();  
        ReportText.clear();
    }

    @FXML //Exit Program
    void ExitButtonPressed(ActionEvent event) {
    Platform.exit();
    }

    @FXML
    void PatientButtonPressed(ActionEvent event) {
        String s1  = PatientNameText.getText(); //Assign S1 to patient textbox.
        
        if (PatientNameText.getText().equals("")) //If blank then let user  know
        {
            PatientNameText.setText("Enter Name!");
        }
        else
          
        
        s1 = s1.toUpperCase() +".txt"; //String to all upper case letters and adds.txt
        
        
        try(Scanner input = new Scanner(Paths.get(s1))) { //Try and open s1
           
            // Open File and Read the contents
            
                
            while (input.hasNext()) { // read data until end of file
                
            BloodPressureText.setText(String.valueOf(input.nextInt()));  // add file contents to textbox 
            WeightBMI.setText(String.valueOf(input.nextInt()));  // add file contents to textbox 
            HeightBMI.setText(String.valueOf(input.nextInt()));  // add file contents to textbox     
            TriglyceridesText.setText(String.valueOf(input.nextInt()));  // add file contents to textbox 
            HDLText.setText(String.valueOf(input.nextInt()));  // add file contents to textbox 
            LDLText.setText(String.valueOf(input.nextInt()));  // add file contents to textbox 
            TotalText.setText(String.valueOf(input.nextInt()));  // add file contents to textbox 
            GlucoseText.setText(String.valueOf(input.nextInt()));  // add file contents to textbox 
            
           } 
         }
         catch (IOException | NoSuchElementException | //Catch Exception
            IllegalStateException e) {
            PatientNameText.setText("File Not Found!"); //If not found, tell user
            
         }
         

}
    
    @FXML
    void GetReultsButtonPressed(ActionEvent event) 
    {
    if (BloodPressureText.getText().equals("")) //If blank then let user know
             
        {
            BloodPressureText.setText("Enter Value!");
        }
        
    else if (!ValidateNumber(BloodPressureText.getText())) //Confirm user entered only numbers
        { 
        BloodPressureText.setText("Invalid Input"); 
        }
    if (WeightBMI.getText().equals(""))//If blank then let user know
             
        {
            WeightBMI.setText("Enter Value!");
        }
    else if (!ValidateNumber(WeightBMI.getText()))  //Confirm user entered only numbers
        { 
        WeightBMI.setText("Invalid Input"); 
        }
    if (HeightBMI.getText().equals(""))//If blank then let user know
             
        {
            HeightBMI.setText("Enter Value!");
        }
    else if (!ValidateNumber(HeightBMI.getText()))  //Confirm user entered only numbers
        { 
        HeightBMI.setText("Invalid Input"); 
        }
    if (GlucoseText.getText().equals(""))//If blank then let user know
             
        {
            GlucoseText.setText("Enter Value!");
        }
    else if (!ValidateNumber(GlucoseText.getText()))//Confirm user entered only numbers  
        { 
        GlucoseText.setText("Invalid Input"); 
        }
    if (TriglyceridesText.getText().equals(""))//If blank then let user know
             
        {
            TriglyceridesText.setText("Enter Value!");
        }
    else if (!ValidateNumber(TriglyceridesText.getText()))  //Confirm user entered only numbers
        { 
        TriglyceridesText.setText("Invalid Input"); 
        }
    if (HDLText.getText().equals("")) //If blank then let user know
             
        {
            HDLText.setText("Enter Value!");
        }
    else if (!ValidateNumber(HDLText.getText())) //Confirm user entered only numbers
        { 
        HDLText.setText("Invalid Input"); 
        }
    if (LDLText.getText().equals("")) //If blank then let user know
             
        {
            LDLText.setText("Enter Value!");
        }
    else if (!ValidateNumber(LDLText.getText())) //Confirm user entered only numbers
        { 
        LDLText.setText("Invalid Input"); 
        }
    if (TotalText.getText().equals("")) //If blank then let user know
             
        {
            TotalText.setText("Enter Value!");
        }
    else if (!ValidateNumber(TotalText.getText())) //Confirm user entered only numbers
        { 
        TotalText.setText("Invalid Input"); 
        }
    if (GlucoseText.getText().equals("")) //If blank then let user know
             
        {
            GlucoseText.setText("Enter Value!");
            
         if (!ValidateNumber(GlucoseText.getText())) //Confirm user entered only numbers
        { 
        GlucoseText.setText("Invalid Input"); 
        }   
            
        }
    
     //--------------------Blood Pressure Conditions-----------------------------------
     
    if(Integer.parseInt(BloodPressureText.getText()) >= 210) 
    {
        ResultsBloodPressure.setText("Very Severe! Go See A Doctor! ");
    }
    if(Integer.parseInt(BloodPressureText.getText()) >= 180&&Integer.parseInt(BloodPressureText.getText())<210)
    {
        ResultsBloodPressure.setText("Severe! ");
    }
    if(Integer.parseInt(BloodPressureText.getText()) >= 160&&Integer.parseInt(BloodPressureText.getText())<180)
    {
        ResultsBloodPressure.setText("Moderate! ");
    }
    if(Integer.parseInt(BloodPressureText.getText()) >= 140&&Integer.parseInt(BloodPressureText.getText())<160)
    {
        ResultsBloodPressure.setText("Mild! ");
    }
    if(Integer.parseInt(BloodPressureText.getText()) >= 90&&Integer.parseInt(BloodPressureText.getText())<140)
    {
        ResultsBloodPressure.setText("Normal! ");
    }
    if(Integer.parseInt(BloodPressureText.getText()) >= 50&&Integer.parseInt(BloodPressureText.getText())<90)
    {
        ResultsBloodPressure.setText("Low! ");
    }
    if(Integer.parseInt(BloodPressureText.getText()) < 50)
    {
        ResultsBloodPressure.setText("Very Low! Go See A Doctor! ");
    }
    
    //------------------------------------BMI Conditions--------------------------------------------------
    double weight = Double.parseDouble(WeightBMI.getText()); //Weight variable
    double height = Double.parseDouble(HeightBMI.getText());//height variable
    double BMI = Math.round((weight*703)/(height*height));//Calculate BMI based on formula found online
    
    if(BMI <= 18.5)
    {
        ResultsBMI.setText("BMI: "+ String.valueOf(BMI)+"-"+"Underweight!");
    }
    if(BMI < 10.0)
    {
        ResultsBMI.setText("BMI: "+ String.valueOf(BMI)+"-"+"Very Underweight! Go See A Doctor!");
    }
    if(BMI > 18.5 && BMI <= 24.9)
    {
        ResultsBMI.setText("BMI: "+ String.valueOf(BMI)+"-"+"Normal!");
    }
    if(BMI > 24.9 && BMI <= 29.9)
    {
        ResultsBMI.setText("BMI: "+ String.valueOf(BMI)+"-"+"Overweight!");
    }
    if(BMI >= 30 )
    {
        ResultsBMI.setText("BMI: "+ String.valueOf(BMI)+"-"+"Obese!");
    }
    if(BMI >= 50 )
    {
        ResultsBMI.setText("BMI: "+ String.valueOf(BMI)+"-"+"Very Obese! Go See A Doctor!");
    }
    
    //------------------------------------Blood Glucose Conditions--------------------------------------------------
     if(Integer.parseInt(GlucoseText.getText()) < 80)
    {
        ResultsBloodGlucose.setText("Out of Control! Go See A Doctor! ");
    }
    if(Integer.parseInt(GlucoseText.getText()) >= 80&&Integer.parseInt(GlucoseText.getText())<=150)
    {
        ResultsBloodGlucose.setText("Excellant! ");
    }
    if(Integer.parseInt(GlucoseText.getText()) > 150&&Integer.parseInt(GlucoseText.getText())<=210)
    {
        ResultsBloodGlucose.setText("Good! ");
    }
    if(Integer.parseInt(GlucoseText.getText()) > 210&&Integer.parseInt(GlucoseText.getText())<=270)
    {
        ResultsBloodGlucose.setText("Marginal! ");
    }
    if(Integer.parseInt(GlucoseText.getText()) > 270&&Integer.parseInt(GlucoseText.getText())<=340)
    {
        ResultsBloodGlucose.setText("Poor! ");
    }
    if(Integer.parseInt(GlucoseText.getText()) > 340&&Integer.parseInt(GlucoseText.getText())<=370)
    {
        ResultsBloodGlucose.setText("Out of Control!");
    }
    if(Integer.parseInt(GlucoseText.getText())>= 371)
    {
        ResultsBloodGlucose.setText("Out of Control! Go See A Doctor!");
    }
    
    //------------------------------------Triglycerides Conditions--------------------------------------------------
        if (Integer.parseInt(TriglyceridesText.getText()) < 250) {
            ResultsTriglycerides.setText("Optimal!");
        }
        if (Integer.parseInt(TriglyceridesText.getText()) >= 250) {
            ResultsTriglycerides.setText("Not Optimal!");
        }
        if (Integer.parseInt(TriglyceridesText.getText()) > 300) {
            ResultsTriglycerides.setText("Very Bad- Go See A Doctor!");
        }
        
    //------------------------------------Cholesterol Conditions--------------------------------------------------
    //HDL
    if (Integer.parseInt(HDLText.getText()) > 40) {
            ResultsHDL.setText("Optimal!");
        }
    if (Integer.parseInt(HDLText.getText()) <= 40) {
            ResultsHDL.setText("Not Optimal!");
        }
    if (Integer.parseInt(HDLText.getText()) <= 10) {
            ResultsHDL.setText("Very Bad- Go See A Doctor!!");
        }
    
    //LDL
    if (Integer.parseInt(LDLText.getText()) < 100) {
            ResultsLDL.setText("Optimal!");
        }
    if (Integer.parseInt(LDLText.getText()) >= 100) {
            ResultsLDL.setText("Not Optimal!");
        }
    if (Integer.parseInt(LDLText.getText()) >= 200) {
            ResultsLDL.setText("Very Bad- Go See A Doctor!!");
        }
    
    //TOTAL Cholesterol
    if (Integer.parseInt(TotalText.getText()) < 200) {
            RetultsTotal.setText("Excellent!");
        }
    if (Integer.parseInt(TotalText.getText()) >= 200) {
            RetultsTotal.setText("Not Optimal!");
        }
    if (Integer.parseInt(TotalText.getText()) >= 300) {
            RetultsTotal.setText("Very Bad- Go See A Doctor!!");
        }
    
    
}
    
    @FXML
    void SaveReportButtonPressed(ActionEvent event) 
    {
if (ReportText.getText().equals(""))//If blank then let user know
             
        {
            ReportText.setText("Enter Value!");
        }
else if (ResultsBloodPressure.getText().equals("")||ResultsBMI.getText().equals("")||ResultsTriglycerides.getText().equals("")||ResultsHDL.getText().equals("")||
        ResultsLDL.getText().equals("")||RetultsTotal.getText().equals("")||ResultsBloodGlucose.getText().equals(""))//If blank then let user know
        //If user has not entered data then let them know     
        {
            ReportText.setText("Enter Data and Press Get Reults!");
        }

else //Create Text File.
{
     String s1  = ReportText.getText(); //Assign S1 to report textbox.
     s1 = s1.toUpperCase() +".txt"; //String to all upper case letters and adds.txt
   try
   {
       File file = new File (s1); //Create new file s1
       if(file.createNewFile())
       {
           ReportText.setText("File Has Been Created!");
       }
       else
       {
           ReportText.setText("File Already Exists!");
       }
   } catch(IOException e)
   {
      ReportText.setText("Error Creating File"); 
      e.printStackTrace();
   }
   
   try{
       FileWriter writer = new FileWriter(s1); //Create file writer object and write s1
       
       //Write BloodPressure Results and Specifications to file
       writer.write("Blood Pressure Ranges:"+"\n");
       writer.write("210+ Very Severe"+"\n");
       writer.write("160-180- Moderate"+"\n");
       writer.write("140-160-Mild"+"\n");
       writer.write("90-140- Normal"+"\n");
       writer.write("50-90 Low"+"\n");
       writer.write("Less than 50- Very Low Go See A Doctor!"+"\n");
       writer.write("Your Results are: "+ ResultsBloodPressure.getText()+"\n");
       writer.write("---------------------------------------------------"+"\n");
       
       
       //Write BMI Results and Specifications to file
       writer.write("Body Mass Index"+"\n");
       writer.write("BMI < 18.5 - Underweight"+"\n");
       writer.write("BMI = 18.5-24.9- Normal"+"\n");
       writer.write("BMI=25.0-29.9- Overweight"+"\n");
       writer.write("BMI > 30- Obese"+"\n");
       writer.write("BMI >= 50- Very Obese, Go See A Doctor!"+"\n");
       writer.write("Your Results are: "+ ResultsBMI.getText()+"\n");
       writer.write("---------------------------------------------------"+"\n");
       
       
       //Write BLood Glucose Hemoglobin Results and Specifications to file
       writer.write("Blood Glucose Hemoglobin"+"\n");
       writer.write("80-120- Excellent"+"\n");
       writer.write("150-180- Good"+"\n");
       writer.write("210-240 Marginal"+"\n");
       writer.write("270-310 Poor"+"\n");
       writer.write("340-370- Out of Control"+"\n");
       writer.write("Your Results are: "+ ResultsBloodGlucose.getText()+"\n");
       writer.write("---------------------------------------------------"+"\n");
       
       
       //Write HDL/LDL/Triglyceride Results and Specifications to file
       writer.write("HDL/LDL/Triglyceride Ranges:"+"\n");
       writer.write("Total Cholesterol: < 200 - Excellent"+"\n");
       writer.write("Triglycerides: < 250 - Optimal"+"\n");
       writer.write("HDL > 40 - Optimal"+"\n");
       writer.write("LDL < 100 - Optimal"+"\n");
       writer.write("Your Results for Total Cholesterol is: "+ RetultsTotal.getText()+"\n");
       writer.write("Your Results for Triglycerides is: "+ ResultsTriglycerides.getText()+"\n");
       writer.write("Your Results for HDL Cholesterol is: "+ ResultsHDL.getText()+"\n");
       writer.write("Your Results for LDL Cholesterol is: "+ ResultsLDL.getText()+"\n");
       writer.write("---------------------------------------------------"+"\n");
       
       writer.close(); //Close File
   }catch(IOException e) //If an error occurs - let user know and print stacktrace
   {
      ReportText.setText("Error Writing to File"); 
      e.printStackTrace(); 
   }
    
}

    }
    
    //Method to check if user inputs only digits 0-9. 
public static boolean ValidateNumber (String string){
    
    return string.matches("[0-9]*");
}
}

