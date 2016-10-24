package fr.sofiane.applications.enums;

import fr.sofiane.applications.dto.EnumDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sofiane on 24/10/2016.
 */
public enum TypePersonneEnum {

    ACTEUR,
    REALISATEUR;

    /**
     * Methode qui expose l'enum sour forme de liste de DTO.
     * @return Tous les elements sous forme de liste.
     */
    public static List<EnumDTO> getAsDTO() {
        final java.util.List<fr.sofiane.applications.dto.EnumDTO> l = new ArrayList<fr.sofiane.applications.dto.EnumDTO>();
        for (final TypePersonneEnum r : TypePersonneEnum.values()) {
            final fr.sofiane.applications.dto.EnumDTO enumDTO = new fr.sofiane.applications.dto.EnumDTO();
            enumDTO.setName(r.name());
            enumDTO.setValue(r.name());
            l.add(enumDTO);
        }
        return l;
    }
}
