<%@ taglib prefix="easyrec" uri="/WEB-INF/tagLib.tld" %>
<%--
  ~ Copyright 2011 Research Studios Austria Forschungsgesellschaft mBH
  ~
  ~ This file is part of easyrec.
  ~
  ~ easyrec is free software: you can redistribute it and/or modify
  ~ it under the terms of the GNU General Public License as published by
  ~ the Free Software Foundation, either version 3 of the License, or
  ~ (at your option) any later version.
  ~
  ~ easyrec is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~ MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~ GNU General Public License for more details.
  ~
  ~ You should have received a copy of the GNU General Public License
  ~ along with easyrec.  If not, see <http://www.gnu.org/licenses/>.
  --%>

<div class="appendbody">
<h1>Recommendation API</h1>

<p>
    We provide full access to easyrec's functionality through a <easyrec:wikiLink name="REST API"
                                                                                  pageName="REST_API_v0.98"/>.
    Recommendations are returned in XML or JSON notation.You can also include a small snippet of
    <easyrec:wikiLink name="javascript code" pageName="JavaScript_API_v0.98"/> in your website to get
    recommendations. To get started with easyrec we recommend to read the <easyrec:wikiLink name="get started guide"/>
    and if you are completely lost feel free to ask us at the <a href="http://sourceforge.net/p/easyrec/forum/"
                                                                 target="_blank">forums</a>.
</p>

<br/>

<br/><br/>
<table width="100%">
    <tr>
        <td colspan="2"><span class="headline">Actions</span>
            <hr>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            view
        </td>
        <td style="width:200px;height:40px;">
            <a target="_blank" href="http://sourceforge.net/p/easyrec/wiki/ActionAPI/#view">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Sending_Actions">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            buy
        </td>
        <td>
            <a target="_blank" href="http://sourceforge.net/p/easyrec/wiki/ActionAPI/#buy">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Sending_Actions">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            rate
        </td>
        <td>
            <a target="_blank" href="http://sourceforge.net/p/easyrec/wiki/ActionAPI/#rate">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Sending_Actions">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            sendaction
        </td>
        <td>
            <a target="_blank" href="http://sourceforge.net/p/easyrec/wiki/ActionAPI/#sendaction">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Sending_Actions">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
</table>

<br/>

<table width="100%">
    <tr>
        <td colspan="2"><span class="headline">Recommendations</span>
            <hr>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            other users also viewed
        </td>
        <td style="width:200px;">
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/RecommendationAPI/#other-users-also-viewed">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Recommendations">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            other users also bought
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/RecommendationAPI/#other-users-also-bought">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Recommendations">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            items rated good by other users
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/RecommendationAPI/#items-rated-good-by-other-users">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Recommendations">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            recommendations for user
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/RecommendationAPI/#recommendations-for-user">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Recommendations">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            related items
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/RecommendationAPI/#related-items">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Recommendations">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            action history for user
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/RecommendationAPI/#action-history-for-user">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Recommendations">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
</table>

<br/>

<table width="100%">
    <tr>
        <td colspan="2"><span class="headline">Community Rankings</span>
            <hr>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            most viewed items
        </td>
        <td style="width:200px;">
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/RankingsAPI/#most-viewed-items">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Rankings">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            most bought items
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/RankingsAPI/#most-bought-items">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Rankings">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            most rated items
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/RankingsAPI/#most-rated-items">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Rankings">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            best rated items
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/RankingsAPI/#best-rated-items">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Rankings">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            worst rated items
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/RankingsAPI/#worst-rated-items">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Rankings">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
</table>

<br/>

<table width="100%">
    <tr>
        <td colspan="2"><span class="headline">Cluster</span>
            <hr>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            clusters
        </td>
        <td style="width:200px;">
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ClusterAPI/#clusters">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Cluster_Related_Information">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>

    <tr>
        <td>
            items of cluster
        </td>
        <td style="width:200px;">
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ClusterAPI/#items-of-cluster">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Cluster_Related_Information">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>

    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            create cluster
        </td>
        <td style="width:200px;">
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ClusterAPI/#create-cluster">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
</table>
            
<br/>

<table width="100%">
    <tr>
        <td colspan="2"><span class="headline">Import API & other functions</span>
            <hr>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            Import rule
        </td>
        <td style="width:200px;">
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ImportAPI/#import-rule">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            Import/update item
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ImportAPI/#importupdate-item">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            set item active
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ImportAPI/#set-item-active">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            item types
        </td>
        <td style="width:200px;">
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ImportAPI/#item-types">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
            <a target="_blank"
               href="http://easyrec.sourceforge.net/wiki/index.php?title=JavaScript_API_v0.98#Receiving_Itemtypes">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-js.png"/>
            </a>
        </td>
    </tr>
</table>

<br/>
<table width="100%">
    <tr>
        <td colspan="2"><span class="headline">Profile API</span>
            <hr>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            Store
        </td>
        <td style="width:200px;">
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ProfileAPI/#store">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            Store item with profile
        </td>
        <td style="width:200px;">
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ProfileAPI/#store-item-with-profile">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
    <tr  style="background-color: rgb(239, 239, 239);">
        <td>
            Delete
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ProfileAPI/#delete">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            Field Delete
        </td>
        <td style="width:200px;">
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ProfileAPI/#field-delete">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            Load
        </td>
        <td style="width:200px;">
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ProfileAPI/#load">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            Field Load
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ProfileAPI/#field-load">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
    <tr style="background-color: rgb(239, 239, 239);">
        <td>
            Field Store
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ProfileAPI/#field-store">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
        <tr>
        <td>
            Field Push
        </td>
        <td>
            <a target="_blank"
               href="http://sourceforge.net/p/easyrec/wiki/ProfileAPI/#field-push">
                <img style="" alt="wiki link" src="${webappPath}/img/button_wiki-rest.png"/>
            </a>
        </td>
    </tr>
</table>

</div>

