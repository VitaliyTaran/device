package com.epam.device.parser.factory;

import com.epam.device.exception.IncorrectTypeException;
import com.epam.device.parser.Parser;
import com.epam.device.parser.dom.DomParser;
import com.epam.device.parser.jaxb.JaxpParser;
import com.epam.device.parser.sax.SaxParser;

public class ParserFactory {
    private static final String INCORRECT_TYPE_MESSAGE = "Type of parser not a enum";

    public Parser createParser(TypeOfParser type) throws IncorrectTypeException {
        Parser parser;
        switch (type) {
            case SAX:
                parser = new SaxParser();
                break;
            case DOM:
                parser = new DomParser();
                break;
            case JAXP:
                parser = new JaxpParser();
                break;
            default:
                throw new IncorrectTypeException(INCORRECT_TYPE_MESSAGE);
        }
        return parser;
    }
}
