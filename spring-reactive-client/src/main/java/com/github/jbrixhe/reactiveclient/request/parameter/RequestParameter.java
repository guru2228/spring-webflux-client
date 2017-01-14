package com.github.jbrixhe.reactiveclient.request.parameter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface RequestParameter {

    String getName();

    List<String> getValues(Map<String, List<String>> parameterValues);

    class DynamicRequestParameter implements RequestParameter {

        private String name;

        DynamicRequestParameter(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<String> getValues(Map<String, List<String>> parameterValues) {
            return parameterValues.getOrDefault(name, Collections.emptyList());
        }
    }

}
