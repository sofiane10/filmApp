package fr.sofiane.applications.enums;

import fr.sofiane.applications.dto.EnumDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sofiane on 24/10/2016.
 */
public enum CategorieFilmEnum {

    COMEDIE,
    HORREUR,
    THRILLER,
    ACTION,
    DRAME,
    ANIMATION,
    POLICIER,
    ESPIONNAGE,
    FANTASTIQUE,
    SCIENCE_FICTION;

    /**
     * Methode qui expose l'enum sour forme de liste de DTO.
     * @return Tous les elements sous forme de liste.
     */
    public static List<EnumDTO> getAsDTO() {
        final List<EnumDTO> l = new ArrayList<EnumDTO>();
        for (final CategorieFilmEnum r : CategorieFilmEnum.values()) {
            final EnumDTO enumDTO = new EnumDTO();
            enumDTO.setName(r.name());
            enumDTO.setValue(r.name());
            l.add(enumDTO);
        }
        return l;
    }


}
