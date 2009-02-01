/* 
    JSPWiki - a JSP-based WikiWiki clone.

    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.  
 */

/**
 * 
 */
package com.ecyrd.jspwiki.ui.migrator;

public enum NodeType
{
    /** Root node */
    ROOT(null, null),
    /** Attribute node */
    ATTRIBUTE("",""),
    /** Attribute node generated by an embedded JSP tag. */
    DYNAMIC_ATTRIBUTE("<",">"),
    /** Text node */
    TEXT("", ""),
    /** CDATA node. */
    CDATA("<![CDATA[","]]>"),
    /** DOCTYPE declaration */
    DOCTYPE("<!DOCTYPE ", ">"),
    /** HTML, XML or XHTML comment tag */
    COMMENT("<!--", "-->"),
    /** HTML, XML or XHTML start tag */
    START_TAG("<", ">"),
    /** HTML or XHTML LINK tag. */
    LINK("<",">"),
    /** HTML or XHTML META tag. */
    META("<",">"),
    /** HTML, XML or XHTML end tag */
    END_TAG("</", ">"),
    /** XML declaration, <em>e.g.</em>, <code>&lt;?xml version="1.0" encoding="UTF-8"?&gt;</code>. */
    DECLARATION("<?","?>"),
    /** HTML, XML or XHTML empty-element tag. */
    EMPTY_ELEMENT_TAG("<", "/>"),
    /** HTML tag, but not sure whether it's a start, end or empty-element tag. */
    UNRESOLVED_TAG("<", null),
    /** JSP comments, e.g., &lt;%-- comment --%&gt; */
    JSP_COMMENT("<%--", "--%>"),
    /**
     * JSP declaration, e.g., &lt;%! declaration; [ declaration; ]+ ...
     * %&gt;
     */
    JSP_DECLARATION("<%!", "%>"),
    /** JSP expression, e.g., &lt;%= expression %&gt; */
    JSP_EXPRESSION("<%=", "%>"),
    /**
     * JSP scriptlet, e.g., &lt;% code fragment %&gt;. Note the whitespace
     * after the %.
     */
    SCRIPTLET("<%", "%>"),
    /**
     * JSP page, import or taglib directive, e.g., &lt;%@ include... %&gt;
     * &lt;%@ page... %&gt; &lt;%@ taglib... %&gt;
     */
    JSP_DIRECTIVE("<%@", "%>");
    private final String m_tagStart;

    private final String m_tagEnd;

    NodeType(String tagStart, String tagEnd )
    {
        m_tagStart = tagStart;
        m_tagEnd = tagEnd;
    }

    public String getTagEnd()
    {
        return m_tagEnd;
    }

    public String getTagStart()
    {
        return m_tagStart;
    }
    
    public String toString() 
    {
        return name();
    }
    
}