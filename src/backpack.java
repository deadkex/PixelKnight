import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class backpack {
    private item[] pack;
    int itemID_Sword = 0;
    int itemID_Shield = 0;

    public backpack(int size_temp)
    {
        pack = new item[size_temp];
    }

    public void checkInv()
    {
        System.out.println("Items:");
        int checkInv_var1_temp = 0;
        while(true)
        {
            if(pack[checkInv_var1_temp] != null)
            {
                if(pack[checkInv_var1_temp].getStatus())
                {
                    if(pack[checkInv_var1_temp].getItemType().equals("Sword"))
                    System.out.println(pack[checkInv_var1_temp].getitemID());
                }
            }
            checkInv_var1_temp = checkInv_var1_temp + 1;
            if(checkInv_var1_temp >= pack.length) break;
        }
    }

    public void setItemStatus(int select_temp, boolean status_temp)
    {
        if(pack[select_temp] != null) pack[select_temp].setStatus(status_temp);
        else System.out.println("Error to set Status.");
    }

    public int newItem(String type_temp,boolean active_temp)
    {
        int pos_temp = checkPack();
        if(pos_temp >= pack.length){}
        else
        {
            switch(type_temp)
            {
                case "sword":
                {
                    pack[pos_temp] = new sword(itemID_Sword);
                    pack[pos_temp].setStatus(active_temp);
                    itemID_Sword = itemID_Sword + 1;
                    break;
                }
                case "shield":
                {
                    pack[pos_temp] = new shield(itemID_Shield);
                    pack[pos_temp].setStatus(active_temp);
                    itemID_Shield = itemID_Shield + 1;
                    break;
                }
            }
        }
        return pos_temp;

    }

    public boolean delItem(String type_temp, String pos_temp)
    {
        boolean abc = false;
        System.out.println("Remove: " + type_temp + " " + pos_temp + " Length: " + pack.length);
        for(int i = 0; i < pack.length; i++)
        {
            if(pack[i] != null)
            {
                if(pack[i].getitemID().equals(pos_temp))
                {
                    System.out.println("removed: " + pack[i].getitemID());
                    pack[i] = null;
                    abc = true;
                }
            }
        }
        return abc;
    }

    private int checkPack()
    {
        int pos_temp;
        for(pos_temp = 0; pos_temp < pack.length; pos_temp++)
        {
            if(pack[pos_temp] == null) break;
        }
        return pos_temp;
    }

    public item[] getPack()
    {
        return pack;
    }
}

class item
{
    private String name;
    private boolean collected;
    private String itemID;
    private String itemType;

    public item(String name_temp, String itemID_temp, String itemType_temp){
        this.name = name_temp;
        this.collected = false;
        this.itemID = itemID_temp;
        this.itemType = itemType_temp;
    }

    public String getName(){   return this.name;   }
    public void setName(String name_temp){   this.name = name_temp;   }

    public boolean getStatus(){ return this.collected;  }
    public void setStatus(boolean status_temp){ this.collected = status_temp;   }

    public String getitemID(){   return this.itemID;   }

    public String getItemType(){    return this.itemType;   }

    public String toString(){return itemID;}
}

class sword extends item{
    public sword(int itemID_temp)
    {
        super("The great sword number " + itemID_temp,"Sword-" + itemID_temp,"Sword");

    }
}
class shield extends item{
    public shield(int itemID_temp)
    {
        super("The great shield number " + itemID_temp, "Shield-" + itemID_temp,"Shield");
    }
}