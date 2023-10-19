package es.upm.miw.apaw_practice.domain.models.aquarium;

import es.upm.miw.apaw_practice.domain.models.aquarium.builders.FishBuilders;

import java.time.LocalDate;


    public class Fish implements TreeFishes {
        private String species;
        private String color;
        private LocalDate dateOfEntrance;

        public Fish(String species, String color, LocalDate dateOfEntrance) {
            this.species = species;
            this.color = color;
            this.dateOfEntrance = dateOfEntrance;
        }
        public static FishBuilders.Species builder(){
            return new Builder();
        }

        public Fish() {
            //empty for framework
        }

        public String getSpecies() {
            return species;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public LocalDate getDateOfEntrance() {
            return dateOfEntrance;
        }

        public void setDateOfEntrance(LocalDate dateOfEntrance) {
            this.dateOfEntrance = dateOfEntrance;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "species='" + species + '\'' +
                    ", color='" + color + '\'' +
                    ", dateOfEntrance=" + dateOfEntrance +
                    '}';
        }
        @Override
        public Boolean isComposite() {
            return false;
        }

        @Override
        public void add(TreeFishes treeFishes) {
            throw new UnsupportedOperationException("Unsupported Operation in Fish leaf");
        }

        @Override
        public void remove(TreeFishes treeFishes) {
            //cannot remove in leaf
        }


        public static class Builder implements FishBuilders.Species, FishBuilders.Color, FishBuilders.DateOfEntrance, FishBuilders.Build {
            private final Fish fish;

            public Builder() {
                this.fish = new Fish();
            }


            @Override
            public FishBuilders.Color species(String species) {
                this.fish.species = species;
                return this;
            }

            @Override
            public FishBuilders.DateOfEntrance color(String color) {
                this.fish.color =color;
                return this;
            }

            @Override
            public FishBuilders.Build dateOfEntrance(LocalDate dateOfEntrance) {
                this.fish.dateOfEntrance= dateOfEntrance;
                return this;
            }

            @Override
            public Fish build() {
                return this.fish;
            }

        }
    }
