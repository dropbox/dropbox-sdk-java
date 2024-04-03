/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;

class GetTemporaryUploadLinkArg {
    // struct files.GetTemporaryUploadLinkArg (files.stone)

    @Nonnull
    protected final CommitInfo commitInfo;
    protected final double duration;

    /**
     *
     * @param commitInfo  Contains the path and other optional modifiers for the
     *     future upload commit. Equivalent to the parameters provided to {@link
     *     DbxUserFilesRequests#upload(String)}. Must not be {@code null}.
     * @param duration  How long before this link expires, in seconds.
     *     Attempting to start an upload with this link longer than this period
     *     of time after link creation will result in an error. Must be greater
     *     than or equal to 60.0 and be less than or equal to 14400.0.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTemporaryUploadLinkArg(@Nonnull CommitInfo commitInfo, double duration) {
        if (commitInfo == null) {
            throw new IllegalArgumentException("Required value for 'commitInfo' is null");
        }
        this.commitInfo = commitInfo;
        if (duration < 60.0) {
            throw new IllegalArgumentException("Number 'duration' is smaller than 60.0");
        }
        if (duration > 14400.0) {
            throw new IllegalArgumentException("Number 'duration' is larger than 14400.0");
        }
        this.duration = duration;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param commitInfo  Contains the path and other optional modifiers for the
     *     future upload commit. Equivalent to the parameters provided to {@link
     *     DbxUserFilesRequests#upload(String)}. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTemporaryUploadLinkArg(@Nonnull CommitInfo commitInfo) {
        this(commitInfo, 14400.0);
    }

    /**
     * Contains the path and other optional modifiers for the future upload
     * commit. Equivalent to the parameters provided to {@link
     * DbxUserFilesRequests#upload(String)}.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public CommitInfo getCommitInfo() {
        return commitInfo;
    }

    /**
     * How long before this link expires, in seconds.  Attempting to start an
     * upload with this link longer than this period  of time after link
     * creation will result in an error.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     14400.0.
     */
    public double getDuration() {
        return duration;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.commitInfo,
            this.duration
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GetTemporaryUploadLinkArg other = (GetTemporaryUploadLinkArg) obj;
            return ((this.commitInfo == other.commitInfo) || (this.commitInfo.equals(other.commitInfo)))
                && (this.duration == other.duration)
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends StructSerializer<GetTemporaryUploadLinkArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetTemporaryUploadLinkArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("commit_info");
            CommitInfo.Serializer.INSTANCE.serialize(value.commitInfo, g);
            g.writeFieldName("duration");
            StoneSerializers.float64().serialize(value.duration, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetTemporaryUploadLinkArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetTemporaryUploadLinkArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                CommitInfo f_commitInfo = null;
                Double f_duration = 14400.0;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("commit_info".equals(field)) {
                        f_commitInfo = CommitInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("duration".equals(field)) {
                        f_duration = StoneSerializers.float64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_commitInfo == null) {
                    throw new JsonParseException(p, "Required field \"commit_info\" missing.");
                }
                value = new GetTemporaryUploadLinkArg(f_commitInfo, f_duration);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
