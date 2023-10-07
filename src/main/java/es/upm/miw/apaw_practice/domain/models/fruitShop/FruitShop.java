package es.upm.miw.apaw_practice.domain.models.fruitShop;

import java.util.List;

public class FruitShop {

        private String name;

        private String address;

        private List<Fruit> fruits;

        public FruitShop() {
                //empty for framework
        }


        public FruitShop(String name, String address, List<Fruit> fruits) {
                this.name = name;
                this.address = address;
                this.fruits = fruits;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public List<Fruit> getFruits() {
                return fruits;
        }

        public void setFruits(List<Fruit> fruits) {
                this.fruits = fruits;
        }

        @Override
        public String toString() {
                return "FruitShop{" +
                        "name='" + name + '\'' +
                        ", address='" + address + '\'' +
                        ", fruits=" + fruits +
                        '}';
        }
}
