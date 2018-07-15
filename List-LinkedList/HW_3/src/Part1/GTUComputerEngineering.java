/**
 * Creted by
 * Burak Demirci
 * 141044091
 */
package Part1;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class GTUComputerEngineering {


    private List<Course> list ;

    /**
     *  Constructor get with file name
     * @param FileMame CSV fileName
     */
    public GTUComputerEngineering(String FileMame){

        list = new LinkedList<Course>();
        readData(FileMame);
    }

    /**
     *  Read data from csv file
     * @param fileName File Name
     */
   private void readData(String fileName){

        try {

            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                list.add(new Course(Integer.valueOf(data[0]),data[1],data[2],Integer.valueOf(data[3]),Integer.valueOf(data[4]),data[5]));
            }

            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
   }


















    /**
     *  getByCode Returns all courses which have given course code.
     * @param code The searching Course code
     * @return List of Course
     * @throws Exception There is no Matching Exception or NullPointer Exception
     */
   public List<Course> getByCode(String code) throws Exception {
       Iterator iter = list.iterator();
       List<Course> ret = new LinkedList<Course>();
       if(code!=null) {
           while (iter.hasNext()) {
               Course c = (Course) iter.next();
               if (c.getCourseCode().equals(code))
                   ret.add(c);
           }
       }else
           throw new NullPointerException();
       if(ret.isEmpty()) {
           throw new Exception(" getByCode -> There is no matching");
       }

       return ret;
   }

    /**
     * listSemesterCourses Returns all courses on given semester
     * @param semester The searching semester
     * @return List of Course
     * @throws Exception There is no Matching or InvalidParameter Exceptions
     */
   public List<Course> listSemesterCourses (int semester) throws Exception {
       Iterator iter = list.iterator();
       if(semester<1 || semester>8)
           throw new InvalidParameterException();

       List<Course> ret =  new LinkedList<Course>();
       while(iter.hasNext()){
           Course c = (Course)iter.next();
           if(c.getSemester()==semester)
               ret.add(c);
       }
       if(ret.isEmpty()) {
           throw new Exception("listSemesterCourses -> There is no matching");
       }
       return ret;
   }

    /**
     *  getByRange Returns all courses from given start index to last index.
     * @param start_index The start index for search
     * @param last_index The last index for serach
     * @return List of Course
     * @throws Exception InvalidParameterException
     */
    public List<Course> getByRange(int start_index, int last_index) throws Exception {

       if(start_index <0 || start_index >list.size() || last_index <0
               || last_index>list.size() || last_index<start_index)
           throw new InvalidParameterException();
       List<Course> ret =  new LinkedList<Course>();
       for(int i=start_index; i<=last_index; i++){
           ret.add(list.get(i));
       }
       return ret;
    }

    /**
     *  toString
     * @return String of GTUComputerEngineering
     */
    @Override
    public String toString(){
        String str="";
        for(int i=0; i<list.size(); i++){
            str += list.get(i).toString();
        }
        return str;
    }

}
