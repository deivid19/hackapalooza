/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

! function(r, e) {
    if ("object" == typeof exports) {
        var n = e();
        "object" == typeof module && module && module.exports && (exports = module.exports = n), exports.randomColor = n
    } else "function" == typeof define && define.amd ? define([], e) : r.randomColor = e()
}(this, function() {
    var o = null,
        s = {};
    r("monochrome", null, [
        [0, 0],
        [100, 0]
    ]), r("red", [-26, 18], [
        [20, 100],
        [30, 92],
        [40, 89],
        [50, 85],
        [60, 78],
        [70, 70],
        [80, 60],
        [90, 55],
        [100, 50]
    ]), r("orange", [19, 46], [
        [20, 100],
        [30, 93],
        [40, 88],
        [50, 86],
        [60, 85],
        [70, 70],
        [100, 70]
    ]), r("yellow", [47, 62], [
        [25, 100],
        [40, 94],
        [50, 89],
        [60, 86],
        [70, 84],
        [80, 82],
        [90, 80],
        [100, 75]
    ]), r("green", [63, 178], [
        [30, 100],
        [40, 90],
        [50, 85],
        [60, 81],
        [70, 74],
        [80, 64],
        [90, 50],
        [100, 40]
    ]), r("blue", [179, 257], [
        [20, 100],
        [30, 86],
        [40, 80],
        [50, 74],
        [60, 60],
        [70, 52],
        [80, 44],
        [90, 39],
        [100, 35]
    ]), r("purple", [258, 282], [
        [20, 100],
        [30, 87],
        [40, 79],
        [50, 70],
        [60, 65],
        [70, 59],
        [80, 52],
        [90, 45],
        [100, 42]
    ]), r("pink", [283, 334], [
        [20, 100],
        [30, 90],
        [40, 86],
        [60, 84],
        [80, 80],
        [90, 75],
        [100, 73]
    ]);
    var u = function(r) {
        if (void 0 !== (r = r || {}).seed && null !== r.seed && r.seed === parseInt(r.seed, 10)) o = r.seed;
        else if ("string" == typeof r.seed) o = function(r) {
            for (var e = 0, n = 0; n !== r.length && !(e >= Number.MAX_SAFE_INTEGER); n++) e += r.charCodeAt(n);
            return e
        }(r.seed);
        else {
            if (void 0 !== r.seed && null !== r.seed) throw new TypeError("The seed value must be an integer or string");
            o = null
        }
        var e, n;
        if (null !== r.count && void 0 !== r.count) {
            var t = r.count,
                a = [];
            for (r.count = null; t > a.length;) o && r.seed && (r.seed += 1), a.push(u(r));
            return r.count = t, a
        }
        return function(r, e) {
            switch (e.format) {
                case "hsvArray":
                    return r;
                case "hslArray":
                    return f(r);
                case "hsl":
                    var n = f(r);
                    return "hsl(" + n[0] + ", " + n[1] + "%, " + n[2] + "%)";
                case "hsla":
                    var t = f(r),
                        a = e.alpha || Math.random();
                    return "hsla(" + t[0] + ", " + t[1] + "%, " + t[2] + "%, " + a + ")";
                case "rgbArray":
                    return l(r);
                case "rgb":
                    var o = l(r);
                    return "rgb(" + o.join(", ") + ")";
                case "rgba":
                    var u = l(r),
                        a = e.alpha || Math.random();
                    return "rgba(" + u.join(", ") + ", " + a + ")";
                default:
                    return function(r) {
                        var e = l(r);

                        function n(r) {
                            var e = r.toString(16);
                            return 1 == e.length ? "0" + e : e
                        }
                        return "#" + n(e[0]) + n(e[1]) + n(e[2])
                    }(r)
            }
        }([e = function(r) {
            var e = i(function(r) {
                if ("number" == typeof parseInt(r)) {
                    var e = parseInt(r);
                    if (e < 360 && 0 < e) return [e, e]
                }
                if ("string" == typeof r)
                    if (s[r]) {
                        var n = s[r];
                        if (n.hueRange) return n.hueRange
                    } else if (r.match(/^#?([0-9A-F]{3}|[0-9A-F]{6})$/i)) {
                    var t = function(r) {
                        r = 3 === (r = r.replace(/^#/, "")).length ? r.replace(/(.)/g, "$1$1") : r;
                        var e = parseInt(r.substr(0, 2), 16) / 255,
                            n = parseInt(r.substr(2, 2), 16) / 255,
                            t = parseInt(r.substr(4, 2), 16) / 255,
                            a = Math.max(e, n, t),
                            o = a - Math.min(e, n, t),
                            u = a ? o / a : 0;
                        switch (a) {
                            case e:
                                return [(n - t) / o % 6 * 60 || 0, u, a];
                            case n:
                                return [60 * ((t - e) / o + 2) || 0, u, a];
                            case t:
                                return [60 * ((e - n) / o + 4) || 0, u, a]
                        }
                    }(r)[0];
                    return [t, t]
                }
                return [0, 360]
            }(r.hue));
            e < 0 && (e = 360 + e);
            return e
        }(r), n = function(r, e) {
            if ("monochrome" === e.hue) return 0;
            if ("random" === e.luminosity) return i([0, 100]);
            var n = (o = r, c(o).saturationRange),
                t = n[0],
                a = n[1];
            var o;
            switch (e.luminosity) {
                case "bright":
                    t = 55;
                    break;
                case "dark":
                    t = a - 10;
                    break;
                case "light":
                    a = 55
            }
            return i([t, a])
        }(e, r), function(r, e, n) {
            var t = function(r, e) {
                    for (var n = c(r).lowerBounds, t = 0; t < n.length - 1; t++) {
                        var a = n[t][0],
                            o = n[t][1],
                            u = n[t + 1][0],
                            s = n[t + 1][1];
                        if (a <= e && e <= u) {
                            var i = (s - o) / (u - a),
                                l = o - i * a;
                            return i * e + l
                        }
                    }
                    return 0
                }(r, e),
                a = 100;
            switch (n.luminosity) {
                case "dark":
                    a = t + 20;
                    break;
                case "light":
                    t = (a + t) / 2;
                    break;
                case "random":
                    t = 0, a = 100
            }
            return i([t, a])
        }(e, n, r)], r)
    };

    function c(r) {
        for (var e in 334 <= r && r <= 360 && (r -= 360), s) {
            var n = s[e];
            if (n.hueRange && r >= n.hueRange[0] && r <= n.hueRange[1]) return s[e]
        }
        return "Color not found"
    }

    function i(r) {
        if (null === o) return Math.floor(r[0] + Math.random() * (r[1] + 1 - r[0]));
        var e = r[1] || 1,
            n = r[0] || 0,
            t = (o = (9301 * o + 49297) % 233280) / 233280;
        return Math.floor(n + t * (e - n))
    }

    function r(r, e, n) {
        var t = n[0][0],
            a = n[n.length - 1][0],
            o = n[n.length - 1][1],
            u = n[0][1];
        s[r] = {
            hueRange: e,
            lowerBounds: n,
            saturationRange: [t, a],
            brightnessRange: [o, u]
        }
    }

    function l(r) {
        var e = r[0];
        0 === e && (e = 1), 360 === e && (e = 359), e /= 360;
        var n = r[1] / 100,
            t = r[2] / 100,
            a = Math.floor(6 * e),
            o = 6 * e - a,
            u = t * (1 - n),
            s = t * (1 - o * n),
            i = t * (1 - (1 - o) * n),
            l = 256,
            c = 256,
            f = 256;
        switch (a) {
            case 0:
                l = t, c = i, f = u;
                break;
            case 1:
                l = s, c = t, f = u;
                break;
            case 2:
                l = u, c = t, f = i;
                break;
            case 3:
                l = u, c = s, f = t;
                break;
            case 4:
                l = i, c = u, f = t;
                break;
            case 5:
                l = t, c = u, f = s
        }
        return [Math.floor(255 * l), Math.floor(255 * c), Math.floor(255 * f)]
    }

    function f(r) {
        var e = r[0],
            n = r[1] / 100,
            t = r[2] / 100,
            a = (2 - n) * t;
        return [e, Math.round(n * t / (a < 1 ? a : 2 - a) * 1e4) / 100, a / 2 * 100]
    }
    return u
});