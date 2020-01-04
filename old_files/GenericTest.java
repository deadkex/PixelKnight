import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenericTest {
    /*
    private String name;
    private Measurement[] MeasureFeld1;

    public GenericTest(String name2)
    {
        this.name = name2;
    }

    public String getName(){    return this.name;   }
    public void setName(String name){   this.name = name;   }

    public Measurement[] getMeasureFeld()
    {
        return this.MeasureFeld1;
    }

    public void setMeasureFeld1FT(){ MeasureFeld1 = new Measurement[4]; }
    public void setMeasureFeld1ST(){ MeasureFeld1 = new Measurement[6]; }

    public void readValues()
    {
        int countGT2 = 0;
        String tempDateTime;
        int Puls, systolBlutdruck, diastolBlutdruck;
        Random randNum;
        do
        {
            tempDateTime = getTheFormatDateTime();
            randNum = new Random();
            Puls = randNum.nextInt((100 - 60) + 1) + 60;
            randNum = new Random();
            systolBlutdruck = randNum.nextInt((130 - 110) + 1) + 110;
            randNum = new Random();
            diastolBlutdruck = randNum.nextInt((86 - 50) + 1) + 50;

            MeasureFeld1[countGT2] = new Measurement(Puls, systolBlutdruck, diastolBlutdruck, tempDateTime);

            countGT2 = countGT2 + 1;
        }
        while(countGT2 < this.MeasureFeld1.length);
    }

    public void print()
    {
        System.out.println("Name: "+this.name);
        for(int i = 0; i < MeasureFeld1.length; i++)
        {
            MeasureFeld1[i].printValues();
        }
    }

    public String getTheFormatDateTime()
    {
        Date theDateD = new Date();
        SimpleDateFormat theFormatter = new SimpleDateFormat("dd.MM.yyyy"+" "+"hh:mm:ss");
        String theFormatDate = theFormatter.format(theDateD);
        return theFormatDate;
    }
    */
}