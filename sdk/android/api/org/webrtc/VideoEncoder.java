/*
 *  Copyright 2017 The WebRTC project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a BSD-style license
 *  that can be found in the LICENSE file in the root of the source
 *  tree. An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */

package org.webrtc;

import android.support.annotation.Nullable;

/**
 * Interface for a video encoder that can be used with WebRTC. All calls will be made on the
 * encoding thread. The encoder may be constructed on a different thread and changing thread after
 * calling release is allowed.
 */
public interface VideoEncoder {
}
