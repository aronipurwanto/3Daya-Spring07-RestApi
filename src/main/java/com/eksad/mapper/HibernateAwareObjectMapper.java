package com.eksad.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

public class HibernateAwareObjectMapper extends ObjectMapper {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HibernateAwareObjectMapper() {
        // This for Hibernate 5; change 5 to 4 or 3 if you need to support
        // Hibernate 4 or Hibernate 3 instead
		Hibernate5Module hbm =new Hibernate5Module();
		hbm.enable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
		hbm.enable(Hibernate5Module.Feature.REPLACE_PERSISTENT_COLLECTIONS);
        registerModule(hbm);
    }
}