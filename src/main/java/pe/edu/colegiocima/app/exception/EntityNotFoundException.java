package pe.edu.colegiocima.app.exception;

import org.springframework.util.StringUtils;
import pe.edu.colegiocima.app.utils.UtilsGeneric;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Class clazz, String... searchParamsMap) {
        super(EntityNotFoundException.formatParams(
                clazz.getSimpleName(), toMap(String.class,String.class,searchParamsMap)
        ));
    }

    private static String formatParams(String value, Map<String,String> params) {
        return StringUtils.capitalize(value) + " no se encontró para los parametros " + params;
    }

    private static <K,V> Map<K,V> toMap(Class<K> keyType, Class<V> valueType,Object... entries) {
        if(entries.length % 2 == 1)  throw  new IllegalArgumentException("Entradas inválidas");

        return IntStream.range(0, entries.length / 2).map(i -> i * 2 )
                .collect(HashMap::new,
                        (m,i) -> m.put(keyType.cast(entries[i]),
                                valueType.cast( entries[i+1])), Map::putAll);
    }
}
