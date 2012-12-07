package weiboclient4j;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.scribe.model.OAuthRequest;
import weiboclient4j.model.Count;
import weiboclient4j.model.Emotion;
import weiboclient4j.model.IdResponse;
import weiboclient4j.model.MidResponse;
import weiboclient4j.model.RepostTimeline;
import weiboclient4j.model.Status;
import weiboclient4j.model.Timeline;
import weiboclient4j.model.TimelineIds;
import weiboclient4j.params.BaseApp;
import weiboclient4j.params.Feature;
import weiboclient4j.params.FilterByAuthor;
import weiboclient4j.params.FilterBySource;
import weiboclient4j.params.FilterByType;
import weiboclient4j.params.Id;
import weiboclient4j.params.InboxType;
import weiboclient4j.params.IsBase62;
import weiboclient4j.params.IsBatch;
import weiboclient4j.params.IsComment;
import weiboclient4j.params.Latitude;
import weiboclient4j.params.ListId;
import weiboclient4j.params.Longitude;
import weiboclient4j.params.Mid;
import weiboclient4j.params.MidType;
import weiboclient4j.params.Paging;
import weiboclient4j.params.ParameterAction;
import weiboclient4j.params.Parameters;
import weiboclient4j.params.ScreenName;
import weiboclient4j.params.StatusParam;
import weiboclient4j.params.TrimUser;
import weiboclient4j.params.Uid;
import weiboclient4j.params.Visible;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Status API
 *
 * @author Hover Ruan
 */
@SuppressWarnings("unchecked")
public class StatusService extends AbstractService {

    public StatusService(WeiboClient2 client) {
        super(client);
    }

    public static interface GetPublicTimelineParam extends ParameterAction {
    }

    public Timeline getPublicTimeline() throws WeiboClientException {
        return getPublicTimeline(Paging.EMPTY);
    }

    /**
     * Optional parameter types: {@link BaseApp}
     */
    public <T extends GetPublicTimelineParam> Timeline getPublicTimeline(T... optionalParams)
            throws WeiboClientException {
        return doGet("statuses/public_timeline", Paging.EMPTY, buildParams(optionalParams), Timeline.class);
    }

    /**
     * Optional parameter types: {@link BaseApp}
     */
    public <T extends GetPublicTimelineParam> Timeline getPublicTimeline(
            Paging paging, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/public_timeline", paging, buildParams(optionalParams), Timeline.class);
    }

    public static interface GetFriendsTimelineParam extends ParameterAction {
    }

    public Timeline getFriendsTimeline() throws WeiboClientException {
        return getFriendsTimeline(Paging.EMPTY);
    }

    /**
     * Optional parameter types: {@link BaseApp}, {@link Feature} and {@link TrimUser}
     */
    public <T extends GetFriendsTimelineParam> Timeline getFriendsTimeline(T... optionalParams)
            throws WeiboClientException {
        return doGet("statuses/friends_timeline", Paging.EMPTY, buildParams(optionalParams), Timeline.class);
    }

    /**
     * Optional parameter types: {@link BaseApp}, {@link Feature} and {@link TrimUser}
     */
    public <T extends GetFriendsTimelineParam> Timeline getFriendsTimeline(
            Paging paging, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/friends_timeline", paging, buildParams(optionalParams), Timeline.class);
    }

    public static interface GetHomeTimelineParam extends ParameterAction {
    }

    public Timeline getHomeTimeline() throws WeiboClientException {
        return getHomeTimeline(Paging.EMPTY);
    }

    /**
     * Optional parameter types: {@link BaseApp}, {@link Feature} and {@link TrimUser}
     */
    public <T extends GetHomeTimelineParam> Timeline getHomeTimeline(T... optionalParams)
            throws WeiboClientException {
        return doGet("statuses/home_timeline", Paging.EMPTY, buildParams(optionalParams), Timeline.class);
    }

    /**
     * Optional parameter types: {@link BaseApp}, {@link Feature} and {@link TrimUser}
     */
    public <T extends GetHomeTimelineParam> Timeline getHomeTimeline(
            Paging paging, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/home_timeline", paging, buildParams(optionalParams), Timeline.class);
    }

    public static interface GetFriendsTimelineIdsParam extends ParameterAction {
    }

    public TimelineIds getFriendsTimelineIds() throws WeiboClientException {
        return getFriendsTimelineIds(Paging.EMPTY);
    }

    /**
     * Optional parameter types: {@link BaseApp} and {@link Feature}
     */
    public <T extends GetFriendsTimelineIdsParam> TimelineIds getFriendsTimelineIds(T... optionalParams)
            throws WeiboClientException {
        return doGet("statuses/friends_timeline/ids", Paging.EMPTY, buildParams(optionalParams), TimelineIds.class);
    }

    /**
     * Optional parameter types: {@link BaseApp} and {@link Feature}
     */
    public <T extends GetFriendsTimelineIdsParam> TimelineIds getFriendsTimelineIds(
            Paging paging, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/friends_timeline/ids", paging, buildParams(optionalParams), TimelineIds.class);
    }

    public static interface GetUserTimelineParam extends ParameterAction {
    }

    /**
     * Optional parameter types: {@link BaseApp}, {@link Feature}, {@link TrimUser}
     */
    public <T extends GetUserTimelineParam> Timeline getUserTimeline(T... optionalParams)
            throws WeiboClientException {
        return getUserTimeline(Uid.EMPTY, ScreenName.EMPTY, Paging.EMPTY, optionalParams);
    }

    /**
     * Optional parameter types: {@link BaseApp}, {@link Feature}, {@link TrimUser}
     */
    public <T extends GetUserTimelineParam> Timeline getUserTimeline(Paging paging, T... optionalParams)
            throws WeiboClientException {
        return getUserTimeline(Uid.EMPTY, ScreenName.EMPTY, paging, optionalParams);
    }

    public Timeline getUserTimeline(Uid uid) throws WeiboClientException {
        return getUserTimeline(uid, Paging.EMPTY);
    }

    /**
     * Optional parameter types: {@link BaseApp}, {@link Feature}, {@link TrimUser}
     */
    public <T extends GetUserTimelineParam> Timeline getUserTimeline(
            Uid uid, T... optionalParams) throws WeiboClientException {
        return getUserTimeline(uid, ScreenName.EMPTY, Paging.EMPTY, optionalParams);
    }

    /**
     * Optional parameter types: {@link BaseApp}, {@link Feature}, {@link TrimUser}
     */
    public <T extends GetUserTimelineParam> Timeline getUserTimeline(
            Uid uid, Paging paging, T... optionalParams) throws WeiboClientException {
        return getUserTimeline(uid, ScreenName.EMPTY, paging, optionalParams);
    }

    public Timeline getUserTimeline(ScreenName screenName) throws WeiboClientException {
        return getUserTimeline(screenName, Paging.EMPTY);
    }

    /**
     * Optional parameter types: {@link BaseApp}, {@link Feature}, {@link TrimUser}
     */
    public <T extends GetUserTimelineParam> Timeline getUserTimeline(
            ScreenName screenName, Paging paging, T... optionalParams) throws WeiboClientException {
        return getUserTimeline(Uid.EMPTY, screenName, paging, optionalParams);
    }

    /**
     * Optional parameter types: {@link BaseApp}, {@link Feature}, {@link TrimUser}
     */
    private <T extends GetUserTimelineParam> Timeline getUserTimeline(
            Uid uid, ScreenName screenName, Paging paging, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/user_timeline", paging,
                buildParams(optionalParams, uid, screenName), Timeline.class);
    }

    public static interface GetUserTimelineIdsParam extends ParameterAction {
    }

    /**
     * Optional parameter types: {@link BaseApp} and {@link Feature}
     */
    public <T extends GetUserTimelineIdsParam> TimelineIds getUserTimelineIds(
            T... optionalParams) throws WeiboClientException {
        return getUserTimelineIds(Uid.EMPTY, ScreenName.EMPTY, Paging.EMPTY, optionalParams);
    }

    /**
     * Optional parameter types: {@link BaseApp} and {@link Feature}
     */
    public <T extends GetUserTimelineIdsParam> TimelineIds getUserTimelineIds(
            Paging paging, T... optionalParams) throws WeiboClientException {
        return getUserTimelineIds(Uid.EMPTY, ScreenName.EMPTY, paging, optionalParams);
    }

    public TimelineIds getUserTimelineIds(ScreenName screenName) throws WeiboClientException {
        return getUserTimelineIds(screenName, Paging.EMPTY);
    }

    /**
     * Optional parameter types: {@link BaseApp} and {@link Feature}
     */
    public <T extends GetUserTimelineIdsParam> TimelineIds getUserTimelineIds(
            ScreenName screenName, T... optionalParams) throws WeiboClientException {
        return getUserTimelineIds(screenName, Paging.EMPTY, optionalParams);
    }

    /**
     * Optional parameter types: {@link BaseApp} and {@link Feature}
     */
    public <T extends GetUserTimelineIdsParam> TimelineIds getUserTimelineIds(
            ScreenName screenName, Paging paging, T... optionalParams) throws WeiboClientException {
        return getUserTimelineIds(Uid.EMPTY, screenName, paging, optionalParams);
    }

    public TimelineIds getUserTimelineIds(Uid uid) throws WeiboClientException {
        return getUserTimelineIds(uid, Paging.EMPTY);
    }

    /**
     * Optional parameter types: {@link BaseApp} and {@link Feature}
     */
    public <T extends GetUserTimelineIdsParam> TimelineIds getUserTimelineIds(
            Uid uid, T... optionalParams) throws WeiboClientException {
        return getUserTimelineIds(uid, Paging.EMPTY, optionalParams);
    }


    /**
     * Optional parameter types: {@link BaseApp} and {@link Feature}
     */
    public <T extends GetUserTimelineIdsParam> TimelineIds getUserTimelineIds(
            Uid uid, Paging paging, T... optionalParams) throws WeiboClientException {
        return getUserTimelineIds(uid, ScreenName.EMPTY, paging, optionalParams);
    }

    /**
     * Optional parameter types: {@link BaseApp} and {@link Feature}
     */
    private <T extends GetUserTimelineIdsParam> TimelineIds getUserTimelineIds(
            Uid uid, ScreenName screenName, Paging paging, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/user_timeline/ids", paging, buildParams(optionalParams, uid, screenName),
                TimelineIds.class);
    }

    public static interface GetRepostTimelineParam extends ParameterAction {
    }

    public RepostTimeline getRepostTimeline(Id id) throws WeiboClientException {
        return getRepostTimeline(id, Paging.EMPTY);
    }

    /**
     * Optional parameter types: {@link FilterByAuthor}
     */
    public <T extends GetRepostTimelineParam> RepostTimeline getRepostTimeline(
            Id id, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/repost_timeline", Paging.EMPTY, buildParams(optionalParams, id), RepostTimeline.class);
    }

    /**
     * Optional parameter types: {@link FilterByAuthor}
     */
    public <T extends GetRepostTimelineParam> RepostTimeline getRepostTimeline(
            Id id, Paging paging, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/repost_timeline", paging, buildParams(optionalParams, id), RepostTimeline.class);
    }

    public static interface GetRepostTimelineIdsParam extends ParameterAction {
    }

    public TimelineIds getRepostTimelineIds(Id id) throws WeiboClientException {
        return getRepostTimelineIds(id, Paging.EMPTY);
    }

    /**
     * Optional parameter types: {@link FilterByAuthor}
     */
    public <T extends GetRepostTimelineIdsParam> TimelineIds getRepostTimelineIds(
            Id id, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/repost_timeline/ids", Paging.EMPTY, buildParams(optionalParams, id), TimelineIds.class);
    }

    /**
     * Optional parameter types: {@link FilterByAuthor}
     */
    public <T extends GetRepostTimelineIdsParam> TimelineIds getRepostTimelineIds(
            Id id, Paging paging, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/repost_timeline/ids", paging, buildParams(optionalParams, id), TimelineIds.class);
    }

    public RepostTimeline getRepostByMe() throws WeiboClientException {
        return getRepostByMe(Paging.EMPTY);
    }

    public RepostTimeline getRepostByMe(Paging paging) throws WeiboClientException {
        return doGet("statuses/repost_by_me", paging, RepostTimeline.class);
    }

    public static interface GetMentionsParam extends ParameterAction {
    }

    /**
     * Optional parameter types: {@link FilterByAuthor}, {@link FilterBySource} and {@link FilterByType}
     */
    public <T extends GetMentionsParam> Timeline getMentions(T... optionalParams) throws WeiboClientException {
        return getMentions(Paging.EMPTY, optionalParams);
    }

    /**
     * Optional parameter types: {@link FilterByAuthor}, {@link FilterBySource} and {@link FilterByType}
     */
    public <T extends GetMentionsParam> Timeline getMentions(Paging paging, T... optionalParams)
            throws WeiboClientException {
        return doGet("statuses/mentions", paging, buildParams(optionalParams), Timeline.class);
    }

    public static interface GetMentionsIdsParam extends ParameterAction {
    }

    /**
     * Optional parameter types: {@link FilterByAuthor}, {@link FilterBySource} and {@link FilterByType}
     */
    public <T extends GetMentionsIdsParam> TimelineIds getMentionsIds(T... optionalParams)
            throws WeiboClientException {
        return doGet("statuses/mentions/ids", Paging.EMPTY, buildParams(optionalParams), TimelineIds.class);
    }

    /**
     * Optional parameter types: {@link FilterByAuthor}, {@link FilterBySource} and {@link FilterByType}
     */
    public <T extends GetMentionsIdsParam> TimelineIds getMentionsIds(
            Paging paging, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/mentions/ids", paging, buildParams(optionalParams), TimelineIds.class);
    }

    public static interface GetBilateralTimelineParam extends ParameterAction {
    }

    /**
     * Optional parameter types: {@link BaseApp} and {@link Feature}
     */
    public <T extends GetBilateralTimelineParam> Timeline getBilateralTimeline(T... optionalParams)
            throws WeiboClientException {
        return doGet("statuses/bilateral_timeline", Paging.EMPTY, buildParams(optionalParams), Timeline.class);
    }

    /**
     * Optional parameter types: {@link BaseApp} and {@link Feature}
     */
    public <T extends GetBilateralTimelineParam> Timeline getBilateralTimeline(
            Paging paging, T... optionalParams) throws WeiboClientException {
        return doGet("statuses/bilateral_timeline", paging, buildParams(optionalParams), Timeline.class);
    }

    public Status show(Id id) throws WeiboClientException {
        return doGet("statuses/show", withParams(id), Status.class);
    }

    public String queryMid(Id id, MidType midType) throws WeiboClientException {
        MidResponse midResponse = doGet("statuses/querymid",
                withParams(id, midType), MidResponse.class);

        return midResponse != null ? midResponse.getMid() : null;
    }

    public Map<Long, String> queryMidList(Collection<Id> idList, MidType midType) throws WeiboClientException {
        // [{"3436240135184587":"yfcLPlKKn"},{"3436255091659029":"yfd9X6XAx"}]
        ArrayNode arrayNode = doGet("statuses/querymid",
                withParams(Id.idParam(idList), midType, IsBase62.Yes), ArrayNode.class);

        Map<Long, String> map = new HashMap<Long, String>();
        for (int i = 0; i < arrayNode.size(); i++) {
            JsonNode node = arrayNode.get(i);
            Iterator<String> fieldNames = node.getFieldNames();
            while (fieldNames.hasNext()) {
                String idString = fieldNames.next();
                map.put(new Long(idString), node.get(idString).asText());
            }
        }

        return map;
    }

    public static interface QueryIdParam extends ParameterAction {
    }

    /**
     * Optional parameter types: {@link InboxType} and {@link IsBase62}
     */
    public <T extends QueryIdParam> long queryId(
            Mid mid, MidType type, T... optionalParams) throws WeiboClientException {
        IdResponse idResponse = doGet("statuses/queryid", buildParams(optionalParams, mid, type), IdResponse.class);

        return idResponse.getId();
    }

    public static interface QueryIdListParam extends ParameterAction {
    }

    public <T extends QueryIdListParam> Map<String, Long> queryIdList(
            Collection<Mid> midList, MidType type, T... optionalParams)
            throws WeiboClientException {
        // [{"yfcLPlKKn":"3436240135184587"},{"yfd9X6XAx":"3436255091659029"}]
        ArrayNode arrayNode = doGet("statuses/queryid", buildParams(optionalParams, Mid.midParam(midList), type,
                IsBatch.Yes), ArrayNode.class);

        Map<String, Long> map = new HashMap<String, Long>();
        for (int i = 0; i < arrayNode.size(); i++) {
            JsonNode node = arrayNode.get(i);
            Iterator<String> fieldNames = node.getFieldNames();
            while (fieldNames.hasNext()) {
                String mid = fieldNames.next();
                map.put(mid, node.get(mid).asLong());
            }
        }

        return map;
    }

    public List<Status> getHotRepostDaily() throws WeiboClientException {
        return getHotRepostDaily(Paging.EMPTY);
    }

    public List<Status> getHotRepostDaily(Paging paging) throws WeiboClientException {
        return getHotRepostDaily(paging, BaseApp.No);
    }

    public List<Status> getHotRepostDaily(Paging paging, BaseApp baseApp) throws WeiboClientException {
        return doGet("statuses/hot/repost_daily",
                paging, withParams(baseApp), Status.TYPE_STATUS_LIST);
    }

    public List<Status> getHotRepostWeekly() throws WeiboClientException {
        return getHotRepostWeekly(Paging.EMPTY);
    }

    public List<Status> getHotRepostWeekly(Paging paging) throws WeiboClientException {
        return getHotRepostWeekly(paging, BaseApp.No);
    }

    public List<Status> getHotRepostWeekly(Paging paging, BaseApp baseApp) throws WeiboClientException {
        return doGet("statuses/hot/repost_weekly",
                paging, withParams(baseApp), Status.TYPE_STATUS_LIST);
    }

    public List<Status> getHotCommentsDaily() throws WeiboClientException {
        return getHotCommentsDaily(Paging.EMPTY);
    }

    public List<Status> getHotCommentsDaily(Paging paging) throws WeiboClientException {
        return getHotCommentsDaily(paging, BaseApp.No);
    }

    public List<Status> getHotCommentsDaily(Paging paging, BaseApp baseApp) throws WeiboClientException {
        return doGet("statuses/hot/comments_daily",
                paging, withParams(baseApp), Status.TYPE_STATUS_LIST);
    }

    public List<Status> getHotCommentsWeekly() throws WeiboClientException {
        return getHotCommentsWeekly(Paging.EMPTY);
    }

    public List<Status> getHotCommentsWeekly(Paging paging) throws WeiboClientException {
        return getHotCommentsWeekly(paging, BaseApp.No);
    }

    public List<Status> getHotCommentsWeekly(Paging paging, BaseApp baseApp) throws WeiboClientException {
        return doGet("statuses/hot/comments_weekly",
                paging, withParams(baseApp), Status.TYPE_STATUS_LIST);
    }

    public List<Count> getStatusesCounts(Collection<Id> ids) throws WeiboClientException {
        return doGet("statuses/count",
                withParams(Id.idsParam(ids)), Count.TYPE_COUNT_LIST);
    }

    public Status repost(Id id, String status) throws WeiboClientException {
        return repost(id, status, IsComment.No);
    }

    public Status repost(Id id, String status, IsComment isComment) throws WeiboClientException {
        return repost(id, new StatusParam(status), isComment);
    }

    public Status repost(Id id, StatusParam status, IsComment isComment) throws WeiboClientException {
        return doPost("statuses/repost", withParams(id, status, isComment), Status.class);
    }

    public Status update(String status) throws WeiboClientException {
        return update(status, null, null);
    }

    public Status update(String status, Latitude latitude, Longitude longitude) throws WeiboClientException {
        return update(new StatusParam(status), latitude, longitude);
    }

    public Status update(StatusParam status, Latitude latitude, Longitude longitude) throws WeiboClientException {
        return doPost("statuses/update", withParams(status, latitude, longitude), Status.class);
    }

    public Status destroy(Id id) throws WeiboClientException {
        return doPost("statuses/destroy", withParams(id), Status.class);
    }

    public Status uploadImageUrl(String status, URL url) throws WeiboClientException {
        return uploadImageUrl(status, url, null, null);
    }

    public Status uploadImageUrl(String status, URL url, Latitude latitude, Longitude longitude) throws WeiboClientException {
        return uploadImageUrl(new StatusParam(status), url, latitude, longitude);
    }

    public Status uploadImageUrl(StatusParam status, URL url, Latitude latitude, Longitude longitude) throws WeiboClientException {
        return doPost("statuses/upload_url_text",
                withParams(status, urlParam(url), latitude, longitude), Status.class);
    }

    public Status uploadImageBinary(StatusParam status, File image) throws WeiboClientException {
        return uploadImageBinary(status, Visible.All, null, image, null, null);
    }

    public Status uploadImageBinary(StatusParam status, Visible visible, ListId listId, File image) throws WeiboClientException {
        return uploadImageBinary(status, visible, listId, image, null, null);
    }

    public Status uploadImageBinary(StatusParam status, File image, Latitude latitude, Longitude longitude) throws WeiboClientException {
        return uploadImageBinary(status, null, null, image, latitude, longitude);
    }

    public Status uploadImageBinary(StatusParam status, Visible visible, ListId listId, File image, Latitude latitude,
                                    Longitude longitude) throws WeiboClientException {
        OAuthRequest request = createPostRequest("statuses/upload");
        Parameters params = withParams(status, visible, listId, latitude, longitude);

        try {
            buildUploadRequest(request, image, params);
        } catch (IOException e) {
            throw new WeiboClientException(e);
        }

        return sendRequestAndGetResponseObject(request, Status.class);
    }

    public List<Emotion> getEmotions() throws WeiboClientException {
        return doGet("emotions", Emotion.TYPE_EMOTION_LIST);
    }
}
