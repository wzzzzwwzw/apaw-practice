package es.upm.miw.apaw_practice.domain.models.zoo;

public class TaxonomicSpecie {


    private String genusName;
    private String speciesName;
    private Boolean inDangerOfExtinction;
    private String habitat;

    public TaxonomicSpecie() {
        //empty for framework
    }

    public TaxonomicSpecie(String speciesName) {
        this.speciesName = speciesName;
    }

    public TaxonomicSpecie(String genusName, String speciesName, Boolean inDangerOfExtinction, String habitat) {
        this.genusName = genusName;
        this.speciesName = speciesName;
        this.inDangerOfExtinction = inDangerOfExtinction;
        this.habitat = habitat;
    }

    public static Builder builder(String speciesName) {
        return new Builder();
    }

    public String getGenusName() {
        return genusName;
    }

    public void setGenusName(String genusName) {
        this.genusName = genusName;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public Boolean getInDangerOfExtinction() {
        return inDangerOfExtinction;
    }

    public void setInDangerOfExtinction(Boolean inDangerOfExtinction) {
        this.inDangerOfExtinction = inDangerOfExtinction;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "TaxonomicSpecie{" +
                "genusName='" + genusName + '\'' +
                ", speciesName='" + speciesName + '\'' +
                ", inDangerOfExtinction=" + inDangerOfExtinction +
                ", habitat='" + habitat + '\'' +
                '}';
    }

    public static class Builder implements TaxonomicSpecieBuilder.SpeciesName, TaxonomicSpecieBuilder.GenusName, TaxonomicSpecieBuilder.InDangerOfExtinction, TaxonomicSpecieBuilder.Habitat, TaxonomicSpecieBuilder.Build {
        private final TaxonomicSpecie taxonomicSpecie;

        public Builder() {
            this.taxonomicSpecie = new TaxonomicSpecie();
        }

        @Override
        public TaxonomicSpecieBuilder.SpeciesName genusName(String genusName) {
            this.taxonomicSpecie.setGenusName(genusName);
            return this;
        }

        @Override
        public TaxonomicSpecieBuilder.InDangerOfExtinction speciesName(String speciesName) {
            this.taxonomicSpecie.setSpeciesName(speciesName);
            return this;
        }

        @Override
        public TaxonomicSpecieBuilder.Habitat inDangerOfExtinction(Boolean inDangerOfExtinction) {
            this.taxonomicSpecie.setInDangerOfExtinction(inDangerOfExtinction);
            return this;
        }

        @Override
        public TaxonomicSpecieBuilder.Build habitat(String habitat) {
            this.taxonomicSpecie.setHabitat(habitat);
            return this;
        }

        @Override
        public TaxonomicSpecie build() {
            return this.taxonomicSpecie;
        }
    }
}
