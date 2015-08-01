import idc
import idaapi
import idautils

class funcfind(object):

    CODE = 2
    def __init__(self):
        pass

    # Get the start addess of the firs segment
    def get_start_ea(self):
        ea = idc.BADADDR
        seg = idc.FirstSeg()

        while seg != idc.BADADDR:
            if idc.GetSegmentAttr(seg, idc.SEGATTR_TYPE) == 2:
                ea = seg
                break
            else:
                seg = idc.NextSeg(seg)

        return ea
    
    # Creates function and code block
    def create_fuction(self, ea=idc.BADADDR):
        func_count = 0
        code_count = 0

        if ea == idc.BADADDR:
            ea = self.get_start_ea()
            if ea == idc.BADADDR:
                ea = idc.FirstSeg()

        
        # Check the function valid or not.
        
        while ea != idc.BADADDR:
            try:
                if idc.GetSegmentAttr(ea, idc.SEGATTR_TYPE) == self.CODE:
                    if idc.GetFunctionName(ea) != '':
                        ea = idc.FindFuncEnd(ea)
                        continue
                    else:
                        if idc.MakeFunction(ea):
                            func_count += 1
                        elif idc.MakeCode(ea):
                            code_count += 1
            except:
                pass

            ea = idc.NextAddr(ea)

        print "Created %d new functions and %d new code blocks\n" % (func_count, code_count)



class main_t(idaapi.plugin_t):
    flags = 0
    comment = ""
    help = ""
    wanted_name = "Define all data and code"
    wanted_hotkey = ""
    def init(self):
        self.menu_context = idaapi.add_menu_item("Options/", "Find funtion", "Alt-9", 0, self.fix_code, (None,))
        return idaapi.PLUGIN_KEEP

    def term(self):
        idaapi.del_menu_item(self.menu_context)
        return None

    def run(self, arg):
        pass

    def fix_code(self, arg):
        cd = funcfind()
        cd.create_fuction()

def PLUGIN_ENTRY():
    return main_t()

