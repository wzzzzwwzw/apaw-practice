package es.upm.miw.apaw_practice.domain.models.zoo;

public interface TaxonomicSpecieBuilder {


    interface GenusName {
        SpeciesName genusName(String genusName);
    }

    interface SpeciesName {
        InDangerOfExtinction speciesName(String speciesName);
    }

    interface InDangerOfExtinction {
        Habitat inDangerOfExtinction(Boolean inDangerOfExtinction);
    }

    interface Habitat {
        Build habitat(String habitat);
    }

    interface Build {
        TaxonomicSpecie build();
    }


}