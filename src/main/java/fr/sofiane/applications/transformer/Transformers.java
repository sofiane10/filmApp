package fr.sofiane.applications.transformer;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sofiane on 21/10/2016.
 */

@Component
public class Transformers {


    ModelMapper modelMapper = new ModelMapper();

    public Object convertToDto(Object o, Class classe) {
        Object oDto = modelMapper.map(o, classe);
        return oDto;
    }

    public Object convertToEntity(Object oDto, Class classe) {
        Object o = modelMapper.map(oDto, classe);
        return o;
    }

    public List convertToListDto(Iterable iterable, Class classe) {
        ArrayList list = new ArrayList<>();
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                list.add(convertToDto(it.next(), classe));
            }
        }
        return list;
    }
}
