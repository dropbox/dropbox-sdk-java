package com.dropbox.core.stone;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;

public abstract class UnionSerializer<T> extends CompositeSerializer<T> {}
