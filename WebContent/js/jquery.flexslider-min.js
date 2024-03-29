(function(a) {
	a.flexslider = function(o, t) {
		var b = a(o),
			d = a.extend({}, a.flexslider.defaults, t),
			g = d.namespace,
			y = "ontouchstart" in window || window.DocumentTouch && document instanceof DocumentTouch,
			z = y ? "touchend" : "click",
			u = "vertical" === d.direction,
			v = d.reverse,
			n = 0 < d.itemWidth,
			x = "fade" === d.animation,
			w = "" !== d.asNavFor,
			j = {};
		a.data(o, "flexslider", b);
		j = {
			init: function() {
				b.animating = !1;
				b.currentSlide = d.startAt;
				b.animatingTo = b.currentSlide;
				b.atEnd = 0 === b.currentSlide || b.currentSlide === b.last;
				b.containerSelector = d.selector.substr(0, d.selector.search(" "));
				b.slides = a(d.selector, b);
				b.container = a(b.containerSelector, b);
				b.count = b.slides.length;
				b.syncExists = 0 < a(d.sync).length;
				"slide" === d.animation && (d.animation = "swing");
				b.prop = u ? "top" : "marginLeft";
				b.args = {};
				b.manualPause = !1;
				var c = b,
					h;
				if (h = !d.video) {
					if (h = !x) {
						if (h = d.useCSS) {
							b: {
								h = document.createElement("div");
								var i = ["perspectiveProperty", "WebkitPerspective", "MozPerspective",
										"OPerspective", "msPerspective"
									],
									f;
								for (f in i) {
									if (void 0 !== h.style[i[f]]) {
										b.pfx = i[f].replace("Perspective", "").toLowerCase();
										b.prop = "-" + b.pfx + "-transform";
										h = !0;
										break b
									}
								}
								h = !1
							}
						}
					}
				}
				c.transitions = h;
				"" !== d.controlsContainer && (b.controlsContainer = 0 < a(d.controlsContainer)
					.length && a(d.controlsContainer));
				"" !== d.manualControls && (b.manualControls = 0 < a(d.manualControls).length && a(d
					.manualControls));
				d.randomize && (b.slides.sort(function() {
					return Math.round(Math.random()) - 0.5
				}), b.container.empty().append(b.slides));
				b.doMath();
				w && j.asNav.setup();
				b.setup("init");
				d.controlNav && j.controlNav.setup();
				d.directionNav && j.directionNav.setup();
				d.keyboard && (1 === a(b.containerSelector).length || d.multipleKeyboard) && a(document)
					.bind("keyup", function(e) {
						e = e.keyCode;
						if (!b.animating && (e === 39 || e === 37)) {
							e = e === 39 ? b.getTarget("next") : e === 37 ? b.getTarget("prev") :
								false;
							b.flexAnimate(e, d.pauseOnAction)
						}
					});
				d.mousewheel && b.bind("mousewheel", function(e, l) {
					e.preventDefault();
					var k = l < 0 ? b.getTarget("next") : b.getTarget("prev");
					b.flexAnimate(k, d.pauseOnAction)
				});
				d.pausePlay && j.pausePlay.setup();
				d.slideshow && (d.pauseOnHover && b.hover(function() {
					!b.manualPlay && !b.manualPause && b.pause()
				}, function() {
					!b.manualPause && !b.manualPlay && b.play()
				}), 0 < d.initDelay ? setTimeout(b.play, d.initDelay) : b.play());
				y && d.touch && j.touch();
				(!x || x && d.smoothHeight) && a(window).bind("resize focus", j.resize);
				setTimeout(function() {
					d.start(b)
				}, 200)
			},
			asNav: {
				setup: function() {
					b.asNav = !0;
					b.animatingTo = Math.floor(b.currentSlide / b.move);
					b.currentItem = b.currentSlide;
					b.slides.removeClass(g + "active-slide").eq(b.currentItem).addClass(g +
						"active-slide");
					b.slides.click(function(c) {
						c.preventDefault();
						var c = a(this),
							e = c.index();
						!a(d.asNavFor).data("flexslider").animating && !c.hasClass("active") &&
							(b.direction = b.currentItem < e ? "next" : "prev", b.flexAnimate(e,
								d.pauseOnAction, !1, !0, !0))
					})
				}
			},
			controlNav: {
				setup: function() {
					b.manualControls ? j.controlNav.setupManual() : j.controlNav.setupPaging()
				},
				setupPaging: function() {
					var c = 1,
						e;
					b.controlNavScaffold = a('<ol class="' + g + "control-nav " + g + ("thumbnails" ===
						d.controlNav ? "control-thumbs" : "control-paging") + '"></ol>');
					if (1 < b.pagingCount) {
						for (var f = 0; f < b.pagingCount; f++) {
							e = "thumbnails" === d.controlNav ? '<img src="' + b.slides.eq(f).attr(
									"data-thumb") + '"/>' : "<a>" + c + "</a>", b.controlNavScaffold
								.append("<li>" + e + "</li>"), c++
						}
					}
					b.controlsContainer ? a(b.controlsContainer).append(b.controlNavScaffold) : b
						.append(b.controlNavScaffold);
					j.controlNav.set();
					j.controlNav.active();
					b.controlNavScaffold.delegate("a, img", z, function(h) {
						h.preventDefault();
						var h = a(this),
							i = b.controlNav.index(h);
						h.hasClass(g + "active") || (b.direction = i > b.currentSlide ? "next" :
							"prev", b.flexAnimate(i, d.pauseOnAction))
					});
					y && b.controlNavScaffold.delegate("a", "click touchstart", function(h) {
						h.preventDefault()
					})
				},
				setupManual: function() {
					b.controlNav = b.manualControls;
					j.controlNav.active();
					b.controlNav.live(z, function(c) {
						c.preventDefault();
						var c = a(this),
							e = b.controlNav.index(c);
						c.hasClass(g + "active") || (e > b.currentSlide ? b.direction = "next" :
							b.direction = "prev", b.flexAnimate(e, d.pauseOnAction))
					});
					y && b.controlNav.live("click touchstart", function(c) {
						c.preventDefault()
					})
				},
				set: function() {
					b.controlNav = a("." + g + "control-nav li " + ("thumbnails" === d.controlNav ?
						"img" : "a"), b.controlsContainer ? b.controlsContainer : b)
				},
				active: function() {
					b.controlNav.removeClass(g + "active").eq(b.animatingTo).addClass(g + "active")
				},
				update: function(e, f) {
					1 < b.pagingCount && "add" === e ? b.controlNavScaffold.append(a("<li><a>" + b
						.count + "</a></li>")) : 1 === b.pagingCount ? b.controlNavScaffold.find(
						"li").remove() : b.controlNav.eq(f).closest("li").remove();
					j.controlNav.set();
					1 < b.pagingCount && b.pagingCount !== b.controlNav.length ? b.update(f, e) : j
						.controlNav.active()
				}
			},
			directionNav: {
				setup: function() {
					var c = a('<ul class="' + g + 'direction-nav"><li><a class="' + g +
						'prev" href="#">' + d.prevText + '</a></li><li><a class="' + g +
						'next" href="#">' + d.nextText + "</a></li></ul>");
					b.controlsContainer ? (a(b.controlsContainer).append(c), b.directionNav = a("." +
						g + "direction-nav li a", b.controlsContainer)) : (b.append(c), b
						.directionNav = a("." + g + "direction-nav li a", b));
					j.directionNav.update();
					b.directionNav.bind(z, function(e) {
						e.preventDefault();
						e = a(this).hasClass(g + "next") ? b.getTarget("next") : b.getTarget(
							"prev");
						b.flexAnimate(e, d.pauseOnAction)
					});
					y && b.directionNav.bind("click touchstart", function(e) {
						e.preventDefault()
					})
				},
				update: function() {
					var c = g + "disabled";
					1 === b.pagingCount ? b.directionNav.addClass(c) : d.animationLoop ? b.directionNav
						.removeClass(c) : 0 === b.animatingTo ? b.directionNav.removeClass(c).filter(
							"." + g + "prev").addClass(c) : b.animatingTo === b.last ? b.directionNav
						.removeClass(c).filter("." + g + "next").addClass(c) : b.directionNav
						.removeClass(c)
				}
			},
			pausePlay: {
				setup: function() {
					var c = a('<div class="' + g + 'pauseplay"><a></a></div>');
					b.controlsContainer ? (b.controlsContainer.append(c), b.pausePlay = a("." + g +
						"pauseplay a", b.controlsContainer)) : (b.append(c), b.pausePlay = a("." +
						g + "pauseplay a", b));
					j.pausePlay.update(d.slideshow ? g + "pause" : g + "play");
					b.pausePlay.bind(z, function(e) {
						e.preventDefault();
						if (a(this).hasClass(g + "pause")) {
							b.manualPause = true;
							b.manualPlay = false;
							b.pause()
						} else {
							b.manualPause = false;
							b.manualPlay = true;
							b.play()
						}
					});
					y && b.pausePlay.bind("click touchstart", function(e) {
						e.preventDefault()
					})
				},
				update: function(c) {
					"play" === c ? b.pausePlay.removeClass(g + "pause").addClass(g + "play").text(d
						.playText) : b.pausePlay.removeClass(g + "play").addClass(g + "pause").text(
						d.pauseText)
				}
			},
			touch: function() {
				function c(e) {
					q = u ? h - e.touches[0].pageY : h - e.touches[0].pageX;
					A = u ? Math.abs(q) < Math.abs(e.touches[0].pageX - i) : Math.abs(q) < Math.abs(e
						.touches[0].pageY - i);
					if (!A || 500 < Number(new Date) - r) {
						e.preventDefault(), !x && b.transitions && (d.animationLoop || (q /= 0 === b
							.currentSlide && 0 > q || b.currentSlide === b.last && 0 < q ? Math
							.abs(q) / s + 2 : 1), b.setProps(l + q, "setTouch"))
					}
				}

				function m() {
					if (b.animatingTo === b.currentSlide && !A && null !== q) {
						var e = v ? -q : q,
							f = 0 < e ? b.getTarget("next") : b.getTarget("prev");
						b.canAdvance(f) && (550 > Number(new Date) - r && 50 < Math.abs(e) || Math.abs(
							e) > s / 2) ? b.flexAnimate(f, d.pauseOnAction) : b.flexAnimate(b
							.currentSlide, d.pauseOnAction, !0)
					}
					o.removeEventListener("touchmove", c, !1);
					o.removeEventListener("touchend", m, !1);
					l = q = i = h = null
				}
				var h, i, l, s, q, r, A = !1;
				o.addEventListener("touchstart", function(e) {
					b.animating ? e.preventDefault() : 1 === e.touches.length && (b.pause(), s =
						u ? b.h : b.w, r = Number(new Date), l = n && v && b.animatingTo ===
						b.last ? 0 : n && v ? b.limit - (b.itemW + d.itemMargin) * b.move *
						b.animatingTo : n && b.currentSlide === b.last ? b.limit : n ? (b
							.itemW + d.itemMargin) * b.move * b.currentSlide : v ? (b.last -
							b.currentSlide + b.cloneOffset) * s : (b.currentSlide + b
							.cloneOffset) * s, h = u ? e.touches[0].pageY : e.touches[0]
						.pageX, i = u ? e.touches[0].pageX : e.touches[0].pageY, o
						.addEventListener("touchmove", c, !1), o.addEventListener(
							"touchend", m, !1))
				}, !1)
			},
			resize: function() {
				!b.animating && b.is(":visible") && (n || b.doMath(), x ? j.smoothHeight() : n ? (b
					.slides.width(b.computedW), b.update(b.pagingCount), b.setProps()) : u ? (b
					.viewport.height(b.h), b.setProps(b.h, "setTotal")) : (d.smoothHeight && j
					.smoothHeight(), b.newSlides.width(b.computedW), b.setProps(b.computedW,
						"setTotal")))
			},
			smoothHeight: function(e) {
				if (!u || x) {
					var f = x ? b : b.viewport;
					e ? f.animate({
						height: b.slides.eq(b.animatingTo).height()
					}, e) : f.height(b.slides.eq(b.animatingTo).height())
				}
			},
			sync: function(c) {
				var h = a(d.sync).data("flexslider"),
					f = b.animatingTo;
				switch (c) {
					case "animate":
						h.flexAnimate(f, d.pauseOnAction, !1, !0);
						break;
					case "play":
						!h.playing && !h.asNav && h.play();
						break;
					case "pause":
						h.pause()
				}
			}
		};
		b.flexAnimate = function(c, e, l, f, h) {
			w && 1 === b.pagingCount && (b.direction = b.currentItem < c ? "next" : "prev");
			if (!b.animating && (b.canAdvance(c, h) || l) && b.is(":visible")) {
				if (w && f) {
					if (l = a(d.asNavFor).data("flexslider"), b.atEnd = 0 === c || c === b.count - 1, l
						.flexAnimate(c, !0, !1, !0, h), b.direction = b.currentItem < c ? "next" : "prev", l
						.direction = b.direction, Math.ceil((c + 1) / b.visible) - 1 !== b.currentSlide &&
						0 !== c) {
						b.currentItem = c, b.slides.removeClass(g + "active-slide").eq(c).addClass(g +
							"active-slide"), c = Math.floor(c / b.visible)
					} else {
						return b.currentItem = c, b.slides.removeClass(g + "active-slide").eq(c).addClass(
							g + "active-slide"), !1
					}
				}
				b.animating = !0;
				b.animatingTo = c;
				d.before(b);
				e && b.pause();
				b.syncExists && !h && j.sync("animate");
				d.controlNav && j.controlNav.active();
				n || b.slides.removeClass(g + "active-slide").eq(c).addClass(g + "active-slide");
				b.atEnd = 0 === c || c === b.last;
				d.directionNav && j.directionNav.update();
				c === b.last && (d.end(b), d.animationLoop || b.pause());
				if (x) {
					b.slides.eq(b.currentSlide).fadeOut(d.animationSpeed, d.easing), b.slides.eq(c).fadeIn(d
						.animationSpeed, d.easing, b.wrapup)
				} else {
					var m = u ? b.slides.filter(":first").height() : b.computedW;
					n ? (c = d.itemWidth > b.w ? 2 * d.itemMargin : d.itemMargin, c = (b.itemW + c) * b
							.move * b.animatingTo, c = c > b.limit && 1 !== b.visible ? b.limit : c) : c =
						0 === b.currentSlide && c === b.count - 1 && d.animationLoop && "next" !== b
						.direction ? v ? (b.count + b.cloneOffset) * m : 0 : b.currentSlide === b.last &&
						0 === c && d.animationLoop && "prev" !== b.direction ? v ? 0 : (b.count + 1) * m :
						v ? (b.count - 1 - c + b.cloneOffset) * m : (c + b.cloneOffset) * m;
					b.setProps(c, "", d.animationSpeed);
					if (b.transitions) {
						if (!d.animationLoop || !b.atEnd) {
							b.animating = !1, b.currentSlide = b.animatingTo
						}
						b.container.unbind("webkitTransitionEnd transitionend");
						b.container.bind("webkitTransitionEnd transitionend", function() {
							b.wrapup(m)
						})
					} else {
						b.container.animate(b.args, d.animationSpeed, d.easing, function() {
							b.wrapup(m)
						})
					}
				}
				d.smoothHeight && j.smoothHeight(d.animationSpeed)
			}
		};
		b.wrapup = function(c) {
			!x && !n && (0 === b.currentSlide && b.animatingTo === b.last && d.animationLoop ? b.setProps(c,
					"jumpEnd") : b.currentSlide === b.last && (0 === b.animatingTo && d
				.animationLoop) && b.setProps(c, "jumpStart"));
			b.animating = !1;
			b.currentSlide = b.animatingTo;
			d.after(b)
		};
		b.animateSlides = function() {
			b.animating || b.flexAnimate(b.getTarget("next"))
		};
		b.pause = function() {
			clearInterval(b.animatedSlides);
			b.playing = !1;
			d.pausePlay && j.pausePlay.update("play");
			b.syncExists && j.sync("pause")
		};
		b.play = function() {
			b.animatedSlides = setInterval(b.animateSlides, d.slideshowSpeed);
			b.playing = !0;
			d.pausePlay && j.pausePlay.update("pause");
			b.syncExists && j.sync("play")
		};
		b.canAdvance = function(c, f) {
			var e = w ? b.pagingCount - 1 : b.last;
			return f ? !0 : w && b.currentItem === b.count - 1 && 0 === c && "prev" === b.direction ? !0 :
				w && 0 === b.currentItem && c === b.pagingCount - 1 && "next" !== b.direction ? !1 : c === b
				.currentSlide && !w ? !1 : d.animationLoop ? !0 : b.atEnd && 0 === b.currentSlide && c ===
				e && "next" !== b.direction ? !1 : b.atEnd && b.currentSlide === e && 0 === c && "next" ===
				b.direction ? !1 : !0
		};
		b.getTarget = function(c) {
			b.direction = c;
			return "next" === c ? b.currentSlide === b.last ? 0 : b.currentSlide + 1 : 0 === b
				.currentSlide ? b.last : b.currentSlide - 1
		};
		b.setProps = function(c, l, h) {
			var i, k = c ? c : (b.itemW + d.itemMargin) * b.move * b.animatingTo;
			i = -1 * function() {
				if (n) {
					return "setTouch" === l ? c : v && b.animatingTo === b.last ? 0 : v ? b.limit - (b
							.itemW + d.itemMargin) * b.move * b.animatingTo : b.animatingTo === b.last ?
						b.limit : k
				}
				switch (l) {
					case "setTotal":
						return v ? (b.count - 1 - b.currentSlide + b.cloneOffset) * c : (b
							.currentSlide + b.cloneOffset) * c;
					case "setTouch":
						return c;
					case "jumpEnd":
						return v ? c : b.count * c;
					case "jumpStart":
						return v ? b.count * c : c;
					default:
						return c
				}
			}() + "px";
			b.transitions && (i = u ? "translate3d(0," + i + ",0)" : "translate3d(" + i + ",0,0)", h =
				void 0 !== h ? h / 1000 + "s" : "0s", b.container.css("-" + b.pfx +
					"-transition-duration", h));
			b.args[b.prop] = i;
			(b.transitions || void 0 === h) && b.container.css(b.args)
		};
		b.setup = function(c) {
			if (x) {
				b.slides.css({
						width: "100%",
						"float": "left",
						marginRight: "-100%",
						position: "relative"
					}), "init" === c && b.slides.eq(b.currentSlide).fadeIn(d.animationSpeed, d.easing), d
					.smoothHeight && j.smoothHeight()
			} else {
				var e, f;
				"init" === c && (b.viewport = a('<div class="' + g + 'viewport"></div>').css({
					overflow: "hidden",
					position: "relative"
				}).appendTo(b).append(b.container), b.cloneCount = 0, b.cloneOffset = 0, v && (f = a
					.makeArray(b.slides).reverse(), b.slides = a(f), b.container.empty().append(b
						.slides)));
				d.animationLoop && !n && (b.cloneCount = 2, b.cloneOffset = 1, "init" !== c && b.container
					.find(".clone").remove(), b.container.append(b.slides.first().clone().addClass(
						"clone")).prepend(b.slides.last().clone().addClass("clone")));
				b.newSlides = a(d.selector, b);
				e = v ? b.count - 1 - b.currentSlide + b.cloneOffset : b.currentSlide + b.cloneOffset;
				u && !n ? (b.container.height(200 * (b.count + b.cloneCount) + "%").css("position",
					"absolute").width("100%"), setTimeout(function() {
					b.newSlides.css({
						display: "block"
					});
					b.doMath();
					b.viewport.height(b.h);
					b.setProps(e * b.h, "init")
				}, "init" === c ? 100 : 0)) : (b.container.width(200 * (b.count + b.cloneCount) + "%"),
					b.setProps(e * b.computedW, "init"), setTimeout(function() {
						b.doMath();
						b.newSlides.css({
							width: b.computedW,
							"float": "left",
							display: "block"
						});
						d.smoothHeight && j.smoothHeight()
					}, "init" === c ? 100 : 0))
			}
			n || b.slides.removeClass(g + "active-slide").eq(b.currentSlide).addClass(g + "active-slide")
		};
		b.doMath = function() {
			var c = b.slides.first(),
				h = d.itemMargin,
				i = d.minItems,
				k = d.maxItems;
			b.w = b.width();
			b.h = c.height();
			b.boxPadding = c.outerWidth() - c.width();
			n ? (b.itemT = d.itemWidth + h, b.minW = i ? i * b.itemT : b.w, b.maxW = k ? k * b.itemT : b.w,
				b.itemW = b.minW > b.w ? (b.w - h * i) / i : b.maxW < b.w ? (b.w - h * k) / k : d
				.itemWidth > b.w ? b.w : d.itemWidth, b.visible = Math.floor(b.w / (b.itemW + h)), b
				.move = 0 < d.move && d.move < b.visible ? d.move : b.visible, b.pagingCount = Math
				.ceil((b.count - b.visible) / b.move + 1), b.last = b.pagingCount - 1, b.limit = 1 === b
				.pagingCount ? 0 : d.itemWidth > b.w ? (b.itemW + 2 * h) * b.count - b.w - h : (b
					.itemW + h) * b.count - b.w - h) : (b.itemW = b.w, b.pagingCount = b.count, b.last =
				b.count - 1);
			b.computedW = b.itemW - b.boxPadding
		};
		b.update = function(c, e) {
			b.doMath();
			n || (c < b.currentSlide ? b.currentSlide += 1 : c <= b.currentSlide && 0 !== c && (b
				.currentSlide -= 1), b.animatingTo = b.currentSlide);
			if (d.controlNav && !b.manualControls) {
				if ("add" === e && !n || b.pagingCount > b.controlNav.length) {
					j.controlNav.update("add")
				} else {
					if ("remove" === e && !n || b.pagingCount < b.controlNav.length) {
						n && b.currentSlide > b.last && (b.currentSlide -= 1, b.animatingTo -= 1), j
							.controlNav.update("remove", b.last)
					}
				}
			}
			d.directionNav && j.directionNav.update()
		};
		b.addSlide = function(c, h) {
			var i = a(c);
			b.count += 1;
			b.last = b.count - 1;
			u && v ? void 0 !== h ? b.slides.eq(b.count - h).after(i) : b.container.prepend(i) : void 0 !==
				h ? b.slides.eq(h).before(i) : b.container.append(i);
			b.update(h, "add");
			b.slides = a(d.selector + ":not(.clone)", b);
			b.setup();
			d.added(b)
		};
		b.removeSlide = function(c) {
			var f = isNaN(c) ? b.slides.index(a(c)) : c;
			b.count -= 1;
			b.last = b.count - 1;
			isNaN(c) ? a(c, b.slides).remove() : u && v ? b.slides.eq(b.last).remove() : b.slides.eq(c)
				.remove();
			b.doMath();
			b.update(f, "remove");
			b.slides = a(d.selector + ":not(.clone)", b);
			b.setup();
			d.removed(b)
		};
		j.init()
	};
	a.flexslider.defaults = {
		namespace: "flex-",
		selector: ".slides > li",
		animation: "fade",
		easing: "swing",
		direction: "horizontal",
		reverse: !1,
		animationLoop: !0,
		smoothHeight: !1,
		startAt: 0,
		slideshow: !0,
		slideshowSpeed: 7000,
		animationSpeed: 600,
		initDelay: 0,
		randomize: !1,
		pauseOnAction: !0,
		pauseOnHover: !1,
		useCSS: !0,
		touch: !0,
		video: !1,
		controlNav: !0,
		directionNav: !0,
		prevText: "",
		nextText: "",
		keyboard: !0,
		multipleKeyboard: !1,
		mousewheel: !1,
		pausePlay: !1,
		pauseText: "",
		playText: "",
		controlsContainer: "",
		manualControls: "",
		sync: "",
		asNavFor: "",
		itemWidth: 0,
		itemMargin: 0,
		minItems: 0,
		maxItems: 0,
		move: 0,
		start: function() {},
		before: function() {},
		after: function() {},
		end: function() {},
		added: function() {},
		removed: function() {}
	};
	a.fn.flexslider = function(b) {
		void 0 === b && (b = {});
		if ("object" === typeof b) {
			return this.each(function() {
				var d = a(this),
					e = d.find(b.selector ? b.selector : ".slides > li");
				1 === e.length ? (e.fadeIn(400), b.start && b.start(d)) : void 0 === d.data(
					"flexslider") && new a.flexslider(this, b)
			})
		}
		var c = a(this).data("flexslider");
		switch (b) {
			case "play":
				c.play();
				break;
			case "pause":
				c.pause();
				break;
			case "next":
				c.flexAnimate(c.getTarget("next"), !0);
				break;
			case "prev":
			case "previous":
				c.flexAnimate(c.getTarget("prev"), !0);
				break;
			default:
				"number" === typeof b && c.flexAnimate(b, !0)
		}
	}
})(jQuery);
