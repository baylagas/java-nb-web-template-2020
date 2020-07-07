package javanbwebtemplate.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;

public class PersonLogic extends Logic
{

    public PersonLogic(String pConnectionString) 
    {
        super(pConnectionString);
    }
    
    public int insertPerson(String pName, int pAge, int pSalary)
    {
        DatabaseX database = getDatabase();
        String sql = "INSERT INTO `cardexdb`.`person` "
                + "(`id`, `name`, `age`, `salary`) VALUES "
                + "(0, '"+pName+"', "+pAge+", "+pSalary+");";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
}
