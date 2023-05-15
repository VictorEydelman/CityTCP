package Collections;

import java.text.SimpleDateFormat;

/**
 * Class City
 */
public class City {
        private final int id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным
        private final String name; //Поле не может быть null, Строка не может быть пустой
        private final Coordinates coordinates; //Поле не может быть null
        private final java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private final Float area; //Значение поля должно быть больше 0, Поле не может быть null
        private final int population; //Значение поля должно быть больше 0
        private final Long metersAboveSeaLevel;
        private final long populationDensity; //Значение поля должно быть больше 0
        private final Long telephoneCode; //Значение поля должно быть больше 0, Максимальное значение поля: 100000
        private final StandardOfLiving standardOfLiving; //Поле не может быть null
        private final Human governor; //Поле не может быть null

        /**
         * Method for this with all name of collection
         * @param id id
         * @param name name of city
         * @param coordinates coordinates
         * @param creationDate creation data
         * @param area area
         * @param population population
         * @param metersAboveSeaLevel metersAboveSeaLevel
         * @param populationDensity populationDensity
         * @param telephoneCode telephoneCode
         * @param standardOfLiving standardOfLiving
         * @param governor governor
         */
        public City(int id, String name, Coordinates coordinates, java.time.LocalDate creationDate, Float area,
                    int population, long metersAboveSeaLevel, long populationDensity, long telephoneCode,
                    StandardOfLiving standardOfLiving, Human governor){
                this.id=id;
                this.name=name;
                this.coordinates=coordinates;
                this.creationDate=creationDate;
                this.area=area;
                this.population=population;
                this.metersAboveSeaLevel=metersAboveSeaLevel;
                this.populationDensity=populationDensity;
                this.telephoneCode=telephoneCode;
                this.standardOfLiving=standardOfLiving;
                this.governor=governor;
        }

        /**
         * Method for get element of collection
         * @return String City
         */
        @Override
        public String toString() {
                return "City [id=" + id + ", name=" + name + ", coordinates.x=" + coordinates.getX()
                        + ", coordinates.y=" + coordinates.getY() + ", creationDate="
                        + creationDate + ", area="  + area + ", population=" + population + ", metersAboveSeaLevel="
                        + metersAboveSeaLevel + ", populationDensity=" + populationDensity + ", telephoneCode="
                        + telephoneCode + ", standardOfLiving="+ standardOfLiving + ", governor="
                        + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(governor.getBirthday()) + "]";
        }

        /**
         * Method for get element of collection
         * @return name of the collection element
         */
        public String String() {
                return  "," + name + "," + coordinates.getX() + "," + coordinates.getY()
                        + ","  + area + "," + population + ","
                        + metersAboveSeaLevel + "," + populationDensity + "," + telephoneCode
                        + ","+ standardOfLiving + "," + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(governor.getBirthday());
        }

        /**
         * Method containing the name of the collection element
         * @return Name of city
         */
        public static String NameCity() {
                return  "key,name,coordinates.getX(),coordinates.getY(),area,population," +
                        "metersAboveSeaLevel,populationDensity,telephoneCode,standardOfLiving," +
                        "governor.getBirthday()";
        }

        /**
         * Method for get id
         * @return id
         */
        public int getid(){
                return id;
        }

        /**
         * Method for get name
         * @return name
         */
        public String getname(){
                return name;
        }

        /**
         * Method for get Coordinate
         * @return Coordinate
         */
        public Coordinates getCoordinates(){
                return coordinates;
        }

        /**
         * Method for get CreationDate
         * @return CreationDate
         */
        public java.time.LocalDate getCreationDate(){
                return creationDate;
        }

        /**
         * Method for get area
         * @return area
         */
        public Float getarea(){
                return area;
        }

        /**
         * Method for get population
         * @return population
         */
        public int getPopulation(){
                return population;
        }

        /**
         * Method for get metersAboveSeaLevel
         * @return metersAboveSeaLevel
         */
        public Long getMetersAboveSeaLevel(){
                return metersAboveSeaLevel;
        }

        /**
         * Method for get telephoneCode
         * @return telephoneCode
         */
        public long getTelephoneCode(){
                return telephoneCode;
        }

        /**
         * Method for get populationDensity
         * @return populationDensity
         */
        public long getpopulationDensity(){
                return populationDensity;
        }

        /**
         * Method for get standardOfLiving
         * @return standardOfLiving
         */
        public StandardOfLiving getStandardOfLiving(){
                return standardOfLiving;
        }

        /**
         * Method for get governor
         * @return governor
         */
        public Human getGovernor(){
                return governor;
        }
}