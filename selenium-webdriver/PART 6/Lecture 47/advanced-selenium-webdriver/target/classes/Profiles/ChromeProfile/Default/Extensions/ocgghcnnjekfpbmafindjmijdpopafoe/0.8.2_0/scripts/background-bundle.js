!function(){"use strict";Object.assign;function e(e,t,s,i){return new(s||(s=Promise))(function(o,n){function r(e){try{l(i.next(e))}catch(e){n(e)}}function c(e){try{l(i.throw(e))}catch(e){n(e)}}function l(e){e.done?o(e.value):new s(function(t){t(e.value)}).then(r,c)}l((i=i.apply(e,t)).next())})}class t{static log(...e){window.__env}}function s(e){return(...t)=>new Promise((s,i)=>e(...t,e=>s(e)))}class i{constructor(e){e&&(this.queryTabs=e.tabs&&s(e.tabs.query),this.sendMessageToTabRaw=e.tabs&&s(e.tabs.sendMessage),this.sendMessageToBackgroundRaw=e.runtime&&s(e.runtime.sendMessage),this.getFromLocalStore=e.storage&&s(e.storage.local.get))}sendMessageToBackground(s){return e(this,void 0,void 0,function*(){if(!this.sendMessageToBackgroundRaw)throw new Error("sendMessageToBackground is not available in this context");return t.log("[cau] send message to background",s),yield this.sendMessageToBackgroundRaw(s)})}sendMessageToTab(s,i){return e(this,void 0,void 0,function*(){if(!this.sendMessageToTabRaw)throw new Error("sendMessageToTab is not available in this context");return t.log("[cau] send message to tab",s,i),yield this.sendMessageToTabRaw(s,i)})}getCurrentTab(){return e(this,void 0,void 0,function*(){if(!this.queryTabs)throw new Error("getCurrentTab is not available in this context");const e=yield this.queryTabs({active:!0,currentWindow:!0});if(e&&1===e.length&&e[0]&&e[0].id)return e[0].id;throw new Error(`failed to identify current tab, got: ${e}`)})}getMainConfig(){return e(this,void 0,void 0,function*(){if(!this.getFromLocalStore)throw new Error("getMainConfig is not available in this context");const e=yield this.getFromLocalStore();return e&&(e.mainConfig||{})})}}class o{copy(e,t){document.oncopy=(s=>{s.clipboardData.setData(t,e),s.preventDefault()}),document.execCommand("Copy",!1,null)}}class n{constructor(t,s,n=new o){if(this.chromeApi=t,this.messageHub=s,this.clipboard=n,this.onContextMenuClicked=(t=>e(this,void 0,void 0,function*(){if(t.menuItemId.startsWith("rxse-selector-send-")){const e=t.menuItemId.slice("rxse-selector-send-".length),{selector:s,tabId:i}=yield this.buildSelector(e);this.sendNewSelector(i,s,e)}else if(t.menuItemId.startsWith("rxse-selector-copy-")){const e=t.menuItemId.slice("rxse-selector-copy-".length);this.buildAndCopySelector(e)}})),!s||!s.getPort)throw new Error("invalid_arg: messageHub");this.chromeApiUtils=new i(t),this.chromeApi.runtime.onInstalled.addListener(()=>this.installContextMenus()),this.chromeApi.contextMenus.onClicked.addListener(e=>this.onContextMenuClicked(e))}static waitFor(e){return new Promise(t=>setTimeout(t,e))}installContextMenus(i){return e(this,void 0,void 0,function*(){const o=s(this.chromeApi.contextMenus.removeAll),n=s(this.chromeApi.contextMenus.create);!i&&this.availableSelectorStrategies||i&&this.availableSelectorStrategies&&this.availableSelectorStrategies.length===i.length&&this.availableSelectorStrategies.every((e,t)=>i[t]===e)||(t.log("[cm] install menus:",i||"<all>"),yield o(),yield n({contexts:["all"],documentUrlPatterns:["http://*/*","https://*/*","file:///*/*"],enabled:!!i&&!!i.length,id:"rxse-all",title:"Selector actions"}),this.availableSelectorStrategies=[],i&&i.length&&(yield Promise.all(i.filter(e=>"rxpath"!==e).map(t=>e(this,void 0,void 0,function*(){yield n({contexts:["all"],id:`rxse-selector-send-${t}`,parentId:"rxse-all",title:"Send "+t,visible:!0})}))),yield n({contexts:["all"],id:"sep-item",parentId:"rxse-all",title:"sep",type:"normal",visible:!0}),yield Promise.all(i.map(t=>e(this,void 0,void 0,function*(){return yield n({contexts:["all"],id:`rxse-selector-copy-${t}`,parentId:"rxse-all",title:"Copy "+t,visible:!0})}))),this.availableSelectorStrategies=i,yield this.toggleAppLinks({})))})}toggleAppLinks(i){return e(this,void 0,void 0,function*(){const o=s(this.chromeApi.contextMenus.update);this.availableSelectorStrategies&&this.availableSelectorStrategies.length&&(t.log("[cm] updating menu items visibility:",this.availableSelectorStrategies||"<all>"),yield Promise.all(this.availableSelectorStrategies.filter(e=>"rxpath"!==e).map(t=>e(this,void 0,void 0,function*(){yield o(`rxse-selector-send-${t}`,{visible:"connected"===i.request})}))),yield o("sep-item",{type:"connected"===i.request?"separator":"normal",visible:"connected"===i.request}))})}updateContextMenu(e,t){return s(this.chromeApi.contextMenus.update)(e,t)}buildAndCopySelector(t){return e(this,void 0,void 0,function*(){const{config:e,tabId:s,selector:i}=yield this.buildSelector(t),o=!e||e.copyWithQuotes?JSON.stringify(i.selector):i.selector;this.clipboard.copy(o,"text/plain"),this.postNewSelector(s,i)})}buildSelector(s){return e(this,void 0,void 0,function*(){const e=yield this.chromeApiUtils.getMainConfig(),{tabId:i,selector:o}=yield this.requestSelectorForMostRecentlyClickedElement("auto"!==s?s:void 0,!e||e.ignoreDynamicIds);return t.log("[cm] received new selector from active tab",i,o),{config:e,tabId:i,selector:o}})}requestSelectorForMostRecentlyClickedElement(t,s=!0){return e(this,void 0,void 0,function*(){const e=yield this.chromeApiUtils.getCurrentTab();return{tabId:e,selector:yield this.requestSelector(e,t,s)}})}requestSelector(t,s,i=!0){return new Promise((o,r)=>{const c=[],l=e=>{"provide-happy-result"===e.msg&&e.matchingElements&&c.push(e)};this.chromeApi.runtime.onMessage.addListener(l);const a=(new Date).getTime();this.chromeApiUtils.sendMessageToTab(t,{msg:"build-selector",forcedSelectorType:s,ignoreDynamicIds:i}).then(()=>e(this,void 0,void 0,function*(){let e,t=0,s=0;for(;s<20;)e!==t?s=0:s++,e=t,yield n.waitFor(10),t=c.length;this.chromeApi.runtime.onMessage.removeListener(l);const i=(new Date).getTime();if(c.sort((e,t)=>t.time-e.time),c.length<1){throw new Error(`time-out: failed to get SelectorBuildResult in ${(i-a)/1e3} s`)}const r=c[0];if(r&&!r.selector)throw new Error(`type error: expected SelectorBuildResult, got ${r}`);o(r)})).catch(r)})}postNewSelector(e,t){const s=this.messageHub.getPort(e);s&&s.postMessage({msg:"update-user-selector",selector:t})}sendNewSelector(e,t,s){const i=this.messageHub.getPort(e);i&&i.postMessage({msg:"send-selector-to-app",selector:t,id:s})}}if(!window.chrome){console.error("background script requires Chrome API!");const e=()=>{},t={addListener:e,removeListener:e};window.chrome={contextMenus:{onClicked:t},runtime:{onConnect:t,onInstalled:t},tabs:{onRemoved:t,onReplaced:t,onActivated:t}}}const r=new class{constructor(e){this.tabPorts={},this.disconnectSubscribers=[],t.log("[mh] init message-hub"),e.runtime.onConnect.addListener(e=>{let s;t.log("[mh] got new connection...");const i=i=>{s||(t.log("[mh] registered tab connection",i),s=i.tabId,this.tabPorts[s]=e)},o=s=>{t.log("[mh] init mapping"),i(s),e.onMessage.removeListener(o)};e.onMessage.addListener(o),e.onDisconnect.addListener(()=>{s&&(t.log("[mh] disconnect",s),this.disconnectSubscribers.forEach(e=>e(s)),delete this.tabPorts[s])})}),e.tabs.onRemoved.addListener(e=>{delete this.tabPorts[e]}),e.tabs.onReplaced.addListener((e,t)=>{delete this.tabPorts[t]})}getPort(e){return this.tabPorts[e]}onDevToolsDisconnect(e){this.disconnectSubscribers.push(e)}}(window.chrome),c=new n(window.chrome,r),l=new class{constructor(e){this.chromeApi=e,this.registeredHandlers=[]}listenToBackgroundRequests(e,s){if(t.log("[bh] register bg request listener",e),!this.chromeApi||!this.chromeApi.runtime||!this.chromeApi.runtime.onMessage)return;const i=(i,o,n)=>{if(i.msg===e){t.log("[bh] received known message in content script",i);const e=s(i);if(e&&"function"==typeof e.then)return e.then(n),!0;n(e)}else t.log("[bh] received unknown message in content script",i)};this.chromeApi.runtime.onMessage.addListener(i),this.registeredHandlers.push(i)}removeAllListeners(){this.registeredHandlers.forEach(e=>this.chromeApi.runtime.onMessage.removeListener(e))}}(window.chrome);let a;l.listenToBackgroundRequests("init-content-script",e=>c.installContextMenus(e.selectorTypes)),l.listenToBackgroundRequests("connection-state-changed",e=>c.toggleAppLinks(e)),l.listenToBackgroundRequests("mouse-target-update",e=>{c.updateContextMenu("rxse-selector-copy-link-text",{enabled:e.elementInfo.isLink}),c.updateContextMenu("rxse-selector-send-link-text",{enabled:e.elementInfo.isLink})}),window.chrome.runtime.onInstalled.addListener(()=>{window.chrome.tabs.query({},e=>{e.forEach(e=>{chrome.tabs.executeScript(e.id,{file:"scripts/inject-bundle.js",allFrames:!0},s=>{t.log("[bg] Injected",s?s.length:0,"times for tab",e.id)})})})}),window.chrome.tabs.onActivated.addListener(e=>{a=e.tabId;const t=r.getPort(e.tabId);t?t.postMessage({msg:"tab-activated"}):c.toggleAppLinks({})}),r.onDevToolsDisconnect(e=>{chrome.tabs.sendMessage(e,{msg:"devtools-disconnected"}),e===a&&c.toggleAppLinks({})})}();